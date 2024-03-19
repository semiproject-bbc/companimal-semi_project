package com.companimal.semiProject.kakaoPay.service;

import com.companimal.semiProject.kakaoPay.model.dto.ApproveDTO;
import com.companimal.semiProject.kakaoPay.model.dto.ReadyDTO;
import com.companimal.semiProject.member.model.dto.MemberDTO;
import com.companimal.semiProject.order.model.dto.GetOrderDetailsInfoDTO;
import com.companimal.semiProject.order.model.dto.GetOrderOptionsInfoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Log
@Service
public class KakaoPay {

    // 결제를 하기 위해서 결제 정보를 kakaopay server에 전달하고 결제 고유번호 (TID)와 URL을 응답받는 단계이다.
    private ReadyDTO readyDTO;                     // 결제 준비
    private ApproveDTO approveDTO;                 // 결제 승인 요청
    private static final ObjectMapper mapper = new ObjectMapper();
    private final HttpSession httpSession;
    private HttpHeaders header() {
        /* Header 내용들 */
//         headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
//         headers.add("Content-Type",MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
//         headers.add("Content-Type","application/json;charset=UTF-8");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "SECRET_KEY DEVDBAB0A42804808880722C0AA6AA528BD47A2C"); // kakao 홈페이지에 있는 admin key
        headers.add("Content-Type", "application/json;charset=UTF-8");
        return headers;
    }

    public KakaoPay(HttpSession httpSession) {
        this.readyDTO = new ReadyDTO();
        this.httpSession = httpSession; // 세션을 선언해준다
    }

    /* 가맹점 주문번호 */


    public String kakaoPayReady() {

        /* 결제 요청을 하기 위해서 제출을 해야할 정보들이 있다.
         * 1. header -> (POST, HOST (url 주소), AUTHORIZATION (권한), CONTENT-TYPE) (header 클래스에서 만듬)
         * 2. body -> (cid, cid_secret, ...)
         * 이런 정보들을 보내야 하기 때문에 POST 방식으로 작성을 해서 -> https://kapi.kakao.com 으로 보낸다
         * */

        RestTemplate restTemplate = new RestTemplate(); // restTempate을 사용해서 kakaopay data를 보내는 방법이다. request (요청)을 받을 때 까지 기달린다

         /*    URL address = new URL("https://open-kapi.kakao.com/online/v1/payment/ready");
            HttpURLConnection connection = (HttpURLConnection) address.openConnection(); // 서버 연결
            connection.setRequestMethod("POST");                                         // 보낸다
            connection.setRequestProperty("Authorization", "SECRET_KEY " + "fb640a13c9c7ad443e512c455ae49116"); // admin key
            connection.setRequestProperty("Content-type", "application/json");
            connection.setDoOutput(true); // 서버한테 전달할게 있는지 없는지

        /* 서버로 요청 보낼 Body */

        System.out.println("kakaoPayReady 도착"); // 잘 왔는지 확인

        /* 회원 정보들을 가져온다 */
        MemberDTO memberDTO = (MemberDTO) httpSession.getAttribute("memberInfo");
        /* 주문결제에서 받아온 정보들 */
        GetOrderDetailsInfoDTO getOrderDetailsInfoDTO = (GetOrderDetailsInfoDTO) httpSession.getAttribute("rewardInfo");
        List<GetOrderOptionsInfoDTO> realGetOrderOptionsInfoDTOList =(List<GetOrderOptionsInfoDTO>)  httpSession.getAttribute("rewardOptInfo");

        int totalNoOfOrder = 0;
        for (GetOrderOptionsInfoDTO getOrderOptionsInfoDTO : realGetOrderOptionsInfoDTOList) {
            totalNoOfOrder += Integer.parseInt(getOrderOptionsInfoDTO.getNoOfOrder()); // 총 주문수량을 더해서 totalNoOfOrder에다가 담는다
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = LocalDate.now().format(formatter);
        Random random = new Random();
        int randomNumber = random.nextInt(90000000) + 10000000;
        String franchiseNo = (formattedDate + "-" + randomNumber); // 가맹점 주문번호

        httpSession.setAttribute("partner_order_id", franchiseNo);


        Map<String, Object> params = new LinkedHashMap<>();
        params.put("cid", "TC0ONETIME");                                   // 가맹점 코드
        params.put("partner_order_id", franchiseNo);                       // 가맹점 주문번호
        params.put("partner_user_id", memberDTO.getMemberName());          // 가맹점 회원 id
        params.put("item_name", getOrderDetailsInfoDTO.getProName());      // 상품명을 넣으면 된다
        params.put("quantity", totalNoOfOrder);                            // 상품 수량 (int)
        params.put("total_amount", httpSession.getAttribute("totalAmount"));                             // 총 주문금액
        /* hard coding 정보들 ..*/
//        params.put("partner_order_id", "asd");                           // 가맹점 주문번호
//        params.put("partner_user_id", "memberDTO.getMemberName()");      // 가맹점 회원 id
//        params.put("item_name", "getOrderDetailsInfoDTO.getProName()");  // 상품명을 넣으면 된다
//        params.put("quantity", 123);       // 상품 수량 (int)
//        params.put("total_amount", 123);                                 // 총 금액   (int)



        params.put("tax_free_amount", 0);                                    // 상품 비과세 금액 (int)
        params.put("approval_url", "http://localhost:8080/kakaoPaySuccess"); // 결제 성공 시 redirect url
        params.put("cancel_url", "http://localhost:8080/kakaoPayCancel");    // 결제 취소 시 redirect url
        params.put("fail_url", "http://localhost:8080/kakaoPayFail");        // 결제 취소 시 redirect url

        String parameter = null;
        try {
            parameter = mapper.writeValueAsString(params);  // 정보를 내보낼 때 모두 다 String형변환을 해야하기 때문에 params을 String형변환을 해준다
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        /* header와 body를 붙이는 방법이다 */
        HttpEntity<String> body = new HttpEntity<>(parameter, header()); // 나중에 같이 보내기 위해서 headers + params 합친다

        System.out.println(body); // 잘 붙었는지 확인

        readyDTO = restTemplate.postForObject("https://open-api.kakaopay.com/online/v1/payment/ready", body, ReadyDTO.class);
        log.info("" + readyDTO); // 받은 정보를 String 값으로 변환을 해서 출력을 한다

        return readyDTO.getNext_redirect_pc_url(); // redirect url을 불러와 결제가 완료되면 해당 주소로 가게끔 설정함
    }

    public ApproveDTO kakaoPayInfo (String pg_token) {

        RestTemplate restTemplate = new RestTemplate();

        // 인증 완료시 응답 받는 pg_token + tid로 최종 승인요청을 합니다
        // 결제 승인 요청이 실패하면 카드사 등 결제 수단의 실패 정보들이 필요하기 때문에 포함될 수 있습니다.
        /* 서버로 요청할 Header */
        MemberDTO memberDTO = (MemberDTO) httpSession.getAttribute("memberInfo");

        /* 서버로 요청할 Body */
        Map<String, Object> params = new LinkedHashMap<>();
        // total_amount 빼고 다 String 형식이다
        params.put("cid","TC0ONETIME");         // 가맹점 코드
        params.put("tid",readyDTO.getTid());    // 결제 고유번호
        params.put("partner_order_id",httpSession.getAttribute("partner_order_id"));  // 가맹점 주문번호
        params.put("partner_user_id",memberDTO.getMemberName());   // 가맹점 회원 id
        params.put("pg_token", pg_token);       // 결제승인 요청을 인증하는 token

        String parameters = null;
        try {
            parameters = mapper.writeValueAsString(params);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        HttpEntity<String> body = new HttpEntity<>(parameters, header()); // 나중에 같이 보내기 위해서 headers + params 합친다
        System.out.println(body);

        approveDTO = restTemplate.postForObject("https://open-api.kakaopay.com/online/v1/payment/approve", body, ApproveDTO.class);
        log.info("" + approveDTO);
        System.out.println(approveDTO.toString());
        log.info("" + approveDTO); // 받은 정보들을 String으로 형변환을 한다

        return approveDTO;
    }
}

