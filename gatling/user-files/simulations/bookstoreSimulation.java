
import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class bookstoreSimulation extends Simulation {

  {
    HttpProtocolBuilder httpProtocol = http
      .baseUrl("http://localhost:9000")
      .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*detectportal\\.firefox\\.com.*"))
      .acceptHeader("application/json, text/plain, */*")
      .acceptEncodingHeader("gzip, deflate")
      .acceptLanguageHeader("en-US,en;q=0.9,el;q=0.8,fi;q=0.7")
      .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36");
    
    Map<CharSequence, String> headers_0 = new HashMap<>();
    headers_0.put("accept", "*/*");
    headers_0.put("authorization", "SAPISIDHASH f949a1157b4c77405882158f029e1819e3de61db");
    headers_0.put("content-type", "application/x-www-form-urlencoded;charset=UTF-8");
    headers_0.put("dnt", "1");
    headers_0.put("origin", "https://ogs.google.com");
    headers_0.put("pragma", "no-cache");
    headers_0.put("sec-ch-ua", "Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105");
    headers_0.put("sec-ch-ua-mobile", "?0");
    headers_0.put("sec-ch-ua-platform", "macOS");
    headers_0.put("sec-fetch-dest", "empty");
    headers_0.put("sec-fetch-mode", "cors");
    headers_0.put("sec-fetch-site", "same-site");
    headers_0.put("x-client-data", "CKm1yQEIhLbJAQijtskBCMG2yQEIqZ3KAQiSocsBCIS8zAEIib3MAQ==");
    headers_0.put("x-goog-authuser", "0");
    
    Map<CharSequence, String> headers_1 = new HashMap<>();
    headers_1.put("accept", "*/*");
    headers_1.put("access-control-request-headers", "authorization,x-goog-authuser");
    headers_1.put("access-control-request-method", "POST");
    headers_1.put("origin", "https://ogs.google.com");
    headers_1.put("pragma", "no-cache");
    headers_1.put("sec-fetch-dest", "empty");
    headers_1.put("sec-fetch-mode", "cors");
    headers_1.put("sec-fetch-site", "same-site");
    
    Map<CharSequence, String> headers_2 = new HashMap<>();
    headers_2.put("accept", "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8");
    headers_2.put("dnt", "1");
    headers_2.put("pragma", "no-cache");
    headers_2.put("sec-ch-ua", "Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105");
    headers_2.put("sec-ch-ua-mobile", "?0");
    headers_2.put("sec-ch-ua-platform", "macOS");
    headers_2.put("sec-fetch-dest", "image");
    headers_2.put("sec-fetch-mode", "no-cors");
    headers_2.put("sec-fetch-site", "cross-site");
    headers_2.put("x-client-data", "CKm1yQEIhLbJAQijtskBCMG2yQEIqZ3KAQiSocsBCIS8zAEIib3MAQ==");
    
    Map<CharSequence, String> headers_6 = new HashMap<>();
    headers_6.put("accept", "text/css,*/*;q=0.1");
    headers_6.put("dnt", "1");
    headers_6.put("pragma", "no-cache");
    headers_6.put("sec-ch-ua", "Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105");
    headers_6.put("sec-ch-ua-mobile", "?0");
    headers_6.put("sec-ch-ua-platform", "macOS");
    headers_6.put("sec-fetch-dest", "style");
    headers_6.put("sec-fetch-mode", "no-cors");
    headers_6.put("sec-fetch-site", "cross-site");
    headers_6.put("x-client-data", "CKm1yQEIhLbJAQijtskBCMG2yQEIqZ3KAQiSocsBCIS8zAEIib3MAQ==");
    
    Map<CharSequence, String> headers_7 = new HashMap<>();
    headers_7.put("accept", "*/*");
    headers_7.put("dnt", "1");
    headers_7.put("pragma", "no-cache");
    headers_7.put("sec-ch-ua", "Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105");
    headers_7.put("sec-ch-ua-mobile", "?0");
    headers_7.put("sec-ch-ua-platform", "macOS");
    headers_7.put("sec-fetch-dest", "script");
    headers_7.put("sec-fetch-mode", "no-cors");
    headers_7.put("sec-fetch-site", "cross-site");
    headers_7.put("x-client-data", "CKm1yQEIhLbJAQijtskBCMG2yQEIqZ3KAQiSocsBCIS8zAEIib3MAQ==");
    
    Map<CharSequence, String> headers_11 = new HashMap<>();
    headers_11.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
    headers_11.put("dnt", "1");
    headers_11.put("pragma", "no-cache");
    headers_11.put("sec-ch-ua", "Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105");
    headers_11.put("sec-ch-ua-mobile", "?0");
    headers_11.put("sec-ch-ua-platform", "macOS");
    headers_11.put("sec-fetch-dest", "iframe");
    headers_11.put("sec-fetch-mode", "navigate");
    headers_11.put("sec-fetch-site", "cross-site");
    headers_11.put("upgrade-insecure-requests", "1");
    headers_11.put("x-client-data", "CKm1yQEIhLbJAQijtskBCMG2yQEIqZ3KAQiSocsBCIS8zAEIib3MAQ==");
    
    Map<CharSequence, String> headers_15 = new HashMap<>();
    headers_15.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
    headers_15.put("Cache-Control", "no-cache");
    headers_15.put("DNT", "1");
    headers_15.put("Pragma", "no-cache");
    headers_15.put("Sec-Fetch-Dest", "document");
    headers_15.put("Sec-Fetch-Mode", "navigate");
    headers_15.put("Sec-Fetch-Site", "none");
    headers_15.put("Sec-Fetch-User", "?1");
    headers_15.put("Upgrade-Insecure-Requests", "1");
    headers_15.put("sec-ch-ua", "Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105");
    headers_15.put("sec-ch-ua-mobile", "?0");
    headers_15.put("sec-ch-ua-platform", "macOS");
    
    Map<CharSequence, String> headers_16 = new HashMap<>();
    headers_16.put("Cache-Control", "no-cache");
    headers_16.put("DNT", "1");
    headers_16.put("Origin", "http://localhost:4200");
    headers_16.put("Pragma", "no-cache");
    headers_16.put("Sec-Fetch-Dest", "empty");
    headers_16.put("Sec-Fetch-Mode", "cors");
    headers_16.put("Sec-Fetch-Site", "same-site");
    headers_16.put("sec-ch-ua", "Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105");
    headers_16.put("sec-ch-ua-mobile", "?0");
    headers_16.put("sec-ch-ua-platform", "macOS");
    
    Map<CharSequence, String> headers_17 = new HashMap<>();
    headers_17.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
    headers_17.put("Cache-Control", "no-cache");
    headers_17.put("DNT", "1");
    headers_17.put("Pragma", "no-cache");
    headers_17.put("Sec-Fetch-Dest", "document");
    headers_17.put("Sec-Fetch-Mode", "navigate");
    headers_17.put("Sec-Fetch-Site", "same-origin");
    headers_17.put("Sec-Fetch-User", "?1");
    headers_17.put("Upgrade-Insecure-Requests", "1");
    headers_17.put("sec-ch-ua", "Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105");
    headers_17.put("sec-ch-ua-mobile", "?0");
    headers_17.put("sec-ch-ua-platform", "macOS");
    
    Map<CharSequence, String> headers_19 = new HashMap<>();
    headers_19.put("Accept", "*/*");
    headers_19.put("Access-Control-Request-Headers", "content-type");
    headers_19.put("Access-Control-Request-Method", "POST");
    headers_19.put("Cache-Control", "no-cache");
    headers_19.put("Origin", "http://localhost:4200");
    headers_19.put("Pragma", "no-cache");
    headers_19.put("Sec-Fetch-Dest", "empty");
    headers_19.put("Sec-Fetch-Mode", "cors");
    headers_19.put("Sec-Fetch-Site", "same-site");
    
    Map<CharSequence, String> headers_20 = new HashMap<>();
    headers_20.put("Cache-Control", "no-cache");
    headers_20.put("Content-Type", "application/json");
    headers_20.put("DNT", "1");
    headers_20.put("Origin", "http://localhost:4200");
    headers_20.put("Pragma", "no-cache");
    headers_20.put("Sec-Fetch-Dest", "empty");
    headers_20.put("Sec-Fetch-Mode", "cors");
    headers_20.put("Sec-Fetch-Site", "same-site");
    headers_20.put("sec-ch-ua", "Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105");
    headers_20.put("sec-ch-ua-mobile", "?0");
    headers_20.put("sec-ch-ua-platform", "macOS");
    
    Map<CharSequence, String> headers_46 = new HashMap<>();
    headers_46.put("Accept", "*/*");
    headers_46.put("Access-Control-Request-Headers", "content-type");
    headers_46.put("Access-Control-Request-Method", "PUT");
    headers_46.put("Cache-Control", "no-cache");
    headers_46.put("Origin", "http://localhost:4200");
    headers_46.put("Pragma", "no-cache");
    headers_46.put("Sec-Fetch-Dest", "empty");
    headers_46.put("Sec-Fetch-Mode", "cors");
    headers_46.put("Sec-Fetch-Site", "same-site");
    
    Map<CharSequence, String> headers_52 = new HashMap<>();
    headers_52.put("Accept", "*/*");
    headers_52.put("Access-Control-Request-Method", "DELETE");
    headers_52.put("Cache-Control", "no-cache");
    headers_52.put("Origin", "http://localhost:4200");
    headers_52.put("Pragma", "no-cache");
    headers_52.put("Sec-Fetch-Dest", "empty");
    headers_52.put("Sec-Fetch-Mode", "cors");
    headers_52.put("Sec-Fetch-Site", "same-site");
    
    String uri1 = "https://lh6.googleusercontent.com/proxy/A81kbDuiS44172UjqL-AOYsahRl-yytK2mf4NPkt32MGk2PPHZYQKYSln_qqwkXzyxwoc-HZh3SA9RCvd4TmlX8peoSeOJhd0VudkcQ=w3840-h2160-p-k-no-nd-mv";
    
    String uri2 = "https://play.google.com/log";
    
    String uri3 = "localhost";
    
    String uri4 = "https://ogs.google.com/u/0/widget/app";
    
    String uri5 = "https://www.google.com/gen_204";
    
    String uri6 = "https://www.gstatic.com";
    
    String uri7 = "https://apis.google.com/_/scs/abc-static/_/js/k=gapi.gapi.en.IK5OmUURd2E.O/m=gapi_iframes,googleapis_client/rt=j/sv=1/d=1/ed=1/rs=AHpOoo932JinkSJHK92WgVjIV-Jwwyu3Rw/cb=gapi.loaded_0";
    
    String uri8 = "https://lh3.googleusercontent.com/ogw";

    ScenarioBuilder scn = scenario("bookstoreSimulation")
      .exec(
        http("request_0")
          .post(uri2 + "?format=json&hasfast=true&authuser=0")
          .headers(headers_0)
          .formParam("[[1,null,null,null,null,null,null,null,null,null,[null,null,null,null,\"en-GB\",null,\"boq_onegooglehttpserver_20220919.04_p0\"]],241,[[\"1664522236648\",null,[],null,null,null,null,\"[1664522236620,[[\\\"4950535922500196698\\\",null,[[2072,1]]],[\\\"1757184925777806825\\\",null,[[94,1]]],[\\\"3079121564595244695\\\",null,[[88,1]]]],null,null,\\\"[2,\\\\\\\"WMove_MS\\\\\\\"]\\\"]\",null,null,null,918030389,null,null,-10800,[null,[],null,\"[[],[],[1763433,1772879,45814370,47977019,48410021],[]]\"],null,null,null,[],2,null,null,null,null,null,[]]],\"1664522236652\",[]]", "")
          .resources(
            http("request_1")
              .options(uri2 + "?format=json&hasfast=true&authuser=0")
              .headers(headers_1)
          )
      )
      .pause(141)
      .exec(
        http("request_2")
          .get(uri1)
          .headers(headers_2)
          .resources(
            http("request_3")
              .get(uri5 + "?use_corp=on&atyp=i&zx=1664522378945&sei=ipg2Y7TRHYLHrgTdt6OwAw&ogf=.76.&ogrp=&ogv=476054333.0&ogd=&ogc=FIN&ogl=en-GB&oggv=quantum%3AgapiBuildLabel&oge=8&ogex=&ogp=243&ogsr=1000&ogus=1&ogad=m.s")
              .headers(headers_2),
            http("request_4")
              .get(uri5 + "?use_corp=on&atyp=i&zx=1664522378963&sei=ipg2Y7TRHYLHrgTdt6OwAw&ogf=.76.&ogrp=&ogv=476054333.0&ogd=&ogc=FIN&ogl=en-GB&oggv=quantum%3AgapiBuildLabel&oge=45&ogex=&ogp=243&ogsr=1000&ogus=1&ogad=att.1%2Cmax.2%2Curl.https%3A%2F%2Fwww%252Egstatic.com%2Fog%2F_%2Fjs%2Fk%3Dog.qtm.en_US.F9GLv3vJthY.O%2Frt%3Dj%2Fm%3Dqgl%252Cq_dnp%2Cqmd%2Cqcwid%2Cqbd%2Cqapid%2Cqald%2Fexm%3Dqaaw%2Cqabr%2Cqadd%2Cqaid%2Cqalo%2Cqebr%2Cqein%2Cqhaw%2Cqhbr%2Cqhch%2Cqhga%2Cqhid%2Cqhin%2Cqhlo%2Cqhmn%2Cqhpc%2Cqhpr%2Cqhsf%2Cqhtt%2Fd%3D1%2Fed%3D1%2Frs%3DAA2YrTudCw2XotoVCZRHW0V_ffgR5WCCig")
              .headers(headers_2),
            http("request_5")
              .get(uri8 + "/AOh-ky3vLbxKq8L42CFWtYfU0uOE8wl8_fS8L_6PXQjk=s32-c-mo")
              .headers(headers_2),
            http("request_6")
              .get(uri6 + "/og/_/ss/k=og.qtm.uvvbB0r1MWM.L.W.O/m=qmd,qcwid/excm=qaaw,qabr,qadd,qaid,qalo,qebr,qein,qhaw,qhbr,qhch,qhga,qhid,qhin,qhlo,qhmn,qhpc,qhpr,qhsf,qhtt/d=1/ed=1/ct=zgms/rs=AA2YrTszIA4tPfGwEm2kl8JzM60_NAWuhg")
              .headers(headers_6),
            http("request_7")
              .get(uri6 + "/og/_/js/k=og.qtm.en_US.F9GLv3vJthY.O/rt=j/m=qgl,q_dnp,qmd,qcwid,qbd,qapid,qald/exm=qaaw,qabr,qadd,qaid,qalo,qebr,qein,qhaw,qhbr,qhch,qhga,qhid,qhin,qhlo,qhmn,qhpc,qhpr,qhsf,qhtt/d=1/ed=1/rs=AA2YrTudCw2XotoVCZRHW0V_ffgR5WCCig")
              .headers(headers_7),
            http("request_8")
              .get(uri6 + "/images/branding/googlelogo/svg/googlelogo_clr_74x24px.svg")
              .headers(headers_2),
            http("request_9")
              .get(uri5 + "?use_corp=on&atyp=i&zx=1664522379063&sei=ipg2Y7TRHYLHrgTdt6OwAw&ogf=.76.&ogrp=&ogv=476054333.0&ogd=&ogc=FIN&ogl=en-GB&oggv=quantum%3AgapiBuildLabel&oge=46&ogex=&ogp=243&ogsr=1000&ogus=1&ogad=att.1%2Cmax.2%2Curl.https%3A%2F%2Fwww%252Egstatic.com%2Fog%2F_%2Fjs%2Fk%3Dog.qtm.en_US.F9GLv3vJthY.O%2Frt%3Dj%2Fm%3Dqgl%252Cq_dnp%2Cqmd%2Cqcwid%2Cqbd%2Cqapid%2Cqald%2Fexm%3Dqaaw%2Cqabr%2Cqadd%2Cqaid%2Cqalo%2Cqebr%2Cqein%2Cqhaw%2Cqhbr%2Cqhch%2Cqhga%2Cqhid%2Cqhin%2Cqhlo%2Cqhmn%2Cqhpc%2Cqhpr%2Cqhsf%2Cqhtt%2Fd%3D1%2Fed%3D1%2Frs%3DAA2YrTudCw2XotoVCZRHW0V_ffgR5WCCig")
              .headers(headers_2),
            http("request_10")
              .get(uri7)
              .headers(headers_7)
          )
      )
      .pause(3)
      .exec(
        http("request_11")
          .get(uri4 + "?origin=chrome-untrusted%3A%2F%2Fnew-tab-page&origin=chrome%3A%2F%2Fnew-tab-page&cn=app&pid=1&spid=243&hl=en-GB&dm=")
          .headers(headers_11)
          .resources(
            http("request_12")
              .get(uri6 + "/_/mss/boq-one-google/_/js/k=boq-one-google.OneGoogleWidgetUi.en_GB.E3K-PJU8dUk.es5.O/am=uAEAQA/d=1/excm=_b,_r,_tp,appwidgetauthview/ed=1/dg=0/wt=2/rs=AM-SdHuevNI8Kj3M8DxNzTkTOeBssqVIbA/m=_b,_tp,_r")
              .headers(headers_7),
            http("request_13")
              .get(uri8 + "/AOh-ky3vLbxKq8L42CFWtYfU0uOE8wl8_fS8L_6PXQjk=s128-b16-cc-rp-mo")
              .headers(headers_2),
            http("request_14")
              .get(uri6 + "/_/mss/boq-one-google/_/js/k=boq-one-google.OneGoogleWidgetUi.en_GB.E3K-PJU8dUk.es5.O/ck=boq-one-google.OneGoogleWidgetUi.kKC_V5PahtY.L.B1.O/am=uAEAQA/d=1/exm=_b,_r,_tp/excm=_b,_r,_tp,appwidgetauthview/ed=1/wt=2/rs=AM-SdHtXVoqxoy0PNjHKLdTN2pKPOOCPkg/ee=cEt90b:ws9Tlc;QGR0gd:Mlhmy;uY49fb:COQbmf;yxTchf:KUM7Z;qddgKe:xQtZb;dIoSBb:SpsfSb;EmZ2Bf:zr1jrb;zxnPse:GkRiKb;EVNhjf:pw70Gc;NSEoX:lazG7b;oGtAuc:sOXFj;eBAeSb:zbML3c;Pjplud:EEDORb;io8t5d:yDVVkb;j7137d:KG2eXe;Oj465e:KG2eXe;ul9GGd:VDovNc;sP4Vbe:VwDzFe;kMFpHd:OTA3Ae;NPKaK:SdcwHb;pXdRYb:MdUzUe;nAFL3:s39S4;iFQyKf:QIhFr;SNUn3:ZwDk9d;LBgRLc:SdcwHb;wR5FRb:O1Gjze/m=n73qwf,ws9Tlc,e5qFLc,GkRiKb,IZT63,UUJqVe,O1Gjze,byfTOb,lsjVmc,xUdipf,OTA3Ae,COQbmf,fKUV3e,aurFic,U0aPgd,ZwDk9d,V3dDOb,mI3LFb,O6y8ed,PrPYRd,MpJwZc,LEikZe,NwH0H,OmgaI,lazG7b,XVMNvd,L1AAkb,KUM7Z,Mlhmy,lKZxSd,s39S4,lwddkf,gychg,w9hDv,EEDORb,RMhBfe,SdcwHb,aW3pY,pw70Gc,EFQ78c,Ulmmrd,ZfAoz,mdR7q,xQtZb,JNoxi,kWgXee,MI6k7c,kjKdXe,BVgquf,QIhFr,ovKuLd,hKSk3e,yDVVkb,hc6Ubd,SpsfSb,KG2eXe,MdUzUe,VwDzFe,zbML3c,zr1jrb,lsPsHb,A7fCU,aDfbSd,yA4AGd,Uas9Hd,pjICDe")
              .headers(headers_7),
            http("request_15")
              .get("http://" + uri3 + ":4200/")
              .headers(headers_15),
            http("request_16")
              .get("/api/books")
              .headers(headers_16)
          )
      )
      .pause(9)
      .exec(
        http("request_17")
          .get("http://" + uri3 + ":4200/")
          .headers(headers_17)
          .resources(
            http("request_18")
              .get("/api/books")
              .headers(headers_16)
          )
      )
      .pause(64)
      .exec(
        http("request_19")
          .options("/api/books")
          .headers(headers_19)
          .resources(
            http("request_20")
              .post("/api/books")
              .headers(headers_20)
              .body(RawFileBody("bookstoresimulation/0020_request.json")),
            http("request_21")
              .get("/api/books")
              .headers(headers_16)
          )
      )
      .pause(3)
      .exec(
        http("request_22")
          .options("/api/books")
          .headers(headers_19)
          .resources(
            http("request_23")
              .post("/api/books")
              .headers(headers_20)
              .body(RawFileBody("bookstoresimulation/0023_request.json")),
            http("request_24")
              .get("/api/books")
              .headers(headers_16)
          )
      )
      .pause(2)
      .exec(
        http("request_25")
          .options("/api/books")
          .headers(headers_19)
          .resources(
            http("request_26")
              .post("/api/books")
              .headers(headers_20)
              .body(RawFileBody("bookstoresimulation/0026_request.json")),
            http("request_27")
              .get("/api/books")
              .headers(headers_16)
          )
      )
      .pause(2)
      .exec(
        http("request_28")
          .options("/api/books")
          .headers(headers_19)
          .resources(
            http("request_29")
              .post("/api/books")
              .headers(headers_20)
              .body(RawFileBody("bookstoresimulation/0029_request.json")),
            http("request_30")
              .get("/api/books")
              .headers(headers_16)
          )
      )
      .pause(2)
      .exec(
        http("request_31")
          .options("/api/books")
          .headers(headers_19)
          .resources(
            http("request_32")
              .post("/api/books")
              .headers(headers_20)
              .body(RawFileBody("bookstoresimulation/0032_request.json")),
            http("request_33")
              .get("/api/books")
              .headers(headers_16)
          )
      )
      .pause(1)
      .exec(
        http("request_34")
          .options("/api/books")
          .headers(headers_19)
          .resources(
            http("request_35")
              .post("/api/books")
              .headers(headers_20)
              .body(RawFileBody("bookstoresimulation/0035_request.json")),
            http("request_36")
              .get("/api/books")
              .headers(headers_16)
          )
      )
      .pause(1)
      .exec(
        http("request_37")
          .options("/api/books")
          .headers(headers_19)
          .resources(
            http("request_38")
              .post("/api/books")
              .headers(headers_20)
              .body(RawFileBody("bookstoresimulation/0038_request.json")),
            http("request_39")
              .get("/api/books")
              .headers(headers_16)
          )
      )
      .pause(12)
      .exec(
        http("request_40")
          .options("/api/books")
          .headers(headers_19)
          .resources(
            http("request_41")
              .post("/api/books")
              .headers(headers_20)
              .body(RawFileBody("bookstoresimulation/0041_request.json")),
            http("request_42")
              .get("/api/books")
              .headers(headers_16)
          )
      )
      .pause(5)
      .exec(
        http("request_43")
          .options("/api/books")
          .headers(headers_19)
          .resources(
            http("request_44")
              .post("/api/books")
              .headers(headers_20)
              .body(RawFileBody("bookstoresimulation/0044_request.json")),
            http("request_45")
              .get("/api/books")
              .headers(headers_16)
          )
      )
      .pause(13)
      .exec(
        http("request_46")
          .options("/api/books/8")
          .headers(headers_46)
          .resources(
            http("request_47")
              .put("/api/books/8")
              .headers(headers_20)
              .body(RawFileBody("bookstoresimulation/0047_request.json")),
            http("request_48")
              .get("/api/books")
              .headers(headers_16)
          )
      )
      .pause(4)
      .exec(
        http("request_49")
          .options("/api/books")
          .headers(headers_19)
          .resources(
            http("request_50")
              .post("/api/books")
              .headers(headers_20)
              .body(RawFileBody("bookstoresimulation/0050_request.json")),
            http("request_51")
              .get("/api/books")
              .headers(headers_16)
          )
      )
      .pause(3)
      .exec(
        http("request_52")
          .options("/api/books/5")
          .headers(headers_52)
          .resources(
            http("request_53")
              .delete("/api/books/5")
              .headers(headers_16),
            http("request_54")
              .get("/api/books")
              .headers(headers_16)
          )
      )
      .pause(19)
      .exec(
        http("request_55")
          .options("/api/books")
          .headers(headers_19)
          .resources(
            http("request_56")
              .post("/api/books")
              .headers(headers_20)
              .body(RawFileBody("bookstoresimulation/0056_request.json")),
            http("request_57")
              .get("/api/books")
              .headers(headers_16)
          )
      )
      .pause(5)
      .exec(
        http("request_58")
          .options("/api/books/7")
          .headers(headers_46)
          .resources(
            http("request_59")
              .put("/api/books/7")
              .headers(headers_20)
              .body(RawFileBody("bookstoresimulation/0059_request.json")),
            http("request_60")
              .get("/api/books")
              .headers(headers_16)
          )
      )
      .pause(14)
      .exec(
        http("request_61")
          .options("/api/books/9")
          .headers(headers_46)
          .resources(
            http("request_62")
              .put("/api/books/9")
              .headers(headers_20)
              .body(RawFileBody("bookstoresimulation/0062_request.json")),
            http("request_63")
              .get("/api/books")
              .headers(headers_16)
          )
      )
      .pause(4)
      .exec(
        http("request_64")
          .options("/api/books/3")
          .headers(headers_52)
          .resources(
            http("request_65")
              .delete("/api/books/3")
              .headers(headers_16),
            http("request_66")
              .get("/api/books")
              .headers(headers_16)
          )
      );

	  setUp(scn.injectOpen(atOnceUsers(3))).protocols(httpProtocol);
  }
}
