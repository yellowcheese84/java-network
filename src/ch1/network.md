# 네트워크

## 1. 네트워크와 네트워킹

### 네트워크
> 네트워크 케이블이나 전화선, 무선 링크 등으로 연결되어 동일한 프로토콜을 사용하는 `디바이스`들의 집합을 말한다.

<img src="../resource/img/ch1/network.jpeg" width="390" height="360" />
            
### 네트워킹
> 네트워크에 연결된 디바이스들 간의 데이터 전송을 말한다.



## 2. 네트워크 통신 방법
- 주소  
    > 디바이스들은 각자의 고유 주소를 사용해서 서로의 위치를 파악하고 통신한다.
  
- 데이터 전송
    > 패킷 사용
    
        * 헤더: 송신자와 수신자의 주소와 체크섬(checksum), 기타 유용한 정보들을 포함한다.        
        * 바디: 전송할 데이터를 바이트 그룹으로 포함한다.
    
<img src="../resource/img/ch1/packet.jpeg" width="647" height="184" />



## 3. OSI 7계층(Open Systems Interconnection 7 Layer)
> OSI 7 계층은 네트워크에서 통신이 일어나는 과정을 7단계로 나눈 것으로, 1970년대 말 IOS(International Oraganization for Standardization)에 의해 만들어 졌다.

1. 물리 계층(Physical Layer)
    > 데이터 링크 계층에서 형성된 데이터 패킷을 전기 신호나 광 신호로 바꾸어 송수신하는 역할을 담당한다.
   
2. 데이터 링크 계층(Data Link Layer)
    > 네트워크 계층으로부터의 메시지를 비트로 변환해서, 물리 계층이 전송할 수 있게 한다. 
    메시지를 데이터 프레임의 포맷으로 만든다. 
    수신자와 발신지 하드웨어 주소를 포함하는 헤더를 추가한다.

3. 네트워크 계층(Network Layer)
    > 다른 장소에 위치한 두 시스템 간의 연결성과 경로 선택을 제공한다. 라우팅 프로토콜을 이용해서 최적의 경로를 선택하며, 선택된 경로를 따라 정보를 보낸다.
  
4. 트랜스포트 계층(Transport Layer)
    > 데이터 전송 서비스를 제공한다. 신뢰성 있는 서비스를 제공하기 위해 가상 회로 구축, 유지와 종료, 전송 오류 검출과 복구 그리고 정보흐름제어의 절차를 제공한다.

5. 세션 계층(Session Layer)
    > 애플리케이션 간 세션을 구축하고 관리하며 종료시키는 역할을 한다. 또한 프리젠테이션 계층 사이의 대화를 동기화시키며 데이터 교환을 관리한다.

6. 프리젠테이션 계층(Presentation Layer)
    > 한 시스템의 애플리케이션에서 보낸 정보를 다른 시스템의 애플리케이션 계층에서 읽을 수 있게 하는 곳이다.

7. 애플리케이션 계층(Application Layer)
    > 사용자와 컴퓨터가 통신하는 곳으로, 통신하고자 하는 상대를 식별하고 그 상대와의 통신을 확보하는 역할을 한다. 또한 통신을 위한 충분한 자원을 보유하고 있는지의 여부를 판단한다.

<img src="../resource/img/ch1/osi_7layer.jpeg" width="721" height="364" />



## 4. 인터넷 프로토콜
> 인터넷은 OSI 3계층인 네트워크 프로토콜에 기반을 둔 하나 이상의 네트워크 모임으로서 전세계적인 `TCP/IP 네트워크`며, `IP 주소` 체계와 `IP 프로토콜`을 사용한다. 


### IP(Internet Protocol)
  > IP는 네트워크 계층에 존재하는 프로토콜로서 TCP와 함께 가장 널리 사용되고 있으며 패킷이 상대방에게 안전하게 전송되는 것을 보장하지 않는다. 즉, 신뢰성 없는 프로토콜이다. 트랜스포트 계층에서 패킷을 안전하게 전달한다는 가정으로 IP는 데이터를 효율적으로 전송하는 것에만 집중하기 때문이다. IP 주소는 32비트 정보로 구성되며, Dot(.)을 구분자로 8비트씩 네 부분으로 나뉜다. 이중 일부는 `네트워크`를 다른 부분은 `호스트`를 나타낸다. 현재의 IP 주소 구조는 낭비가 심해 하나의 네트워크를 좀더 작은 네트워크로 나누기 위해 하위넷(로컬 네트워크)을 사용한다.(ex: 공유기)
        
<img src="../resource/img/ch1/ip_address.png" width="500" height="250" />

    
### ICMP(Internet Control Message Protocol)
  > IP에 내장된 오류 처리, 보고 메커니즘 기능을 추가한 프로토콜이다. 전송하는 역할은 IP가 담당하지만 오류 보고와 기타 제어 메시지를 포함시키기 위해 IP에 덧붙여서 ICMP를 사용한다.


### TCP(Transmission Control Protocol)
  > 전송할 데이터가 안전하게 전달되는 것을 보장하는 신뢰성 있는 프로토콜이다. 전달되는 데이터는 발신자가 보내는 것과 같은 순서로 수신자에게 전달된다. 그리고 소켓과 포트를 이용해서 다중 송수신을 지원한다. UDP에 비해 프로토콜이 복잡하고 속도도 느리지만 신뢰성 있는 전송이 가능하다는 장점 때문에 HTTP, FTP, TELNET 등 TCP를 이용한다. ex) 전화통화, 채팅 프로그램
  

### UDP(User Datagram Protocol)
  > 전송한 데이터가 잘 저달되었는지 확인하지 않는 신로성 없는 비연결지향 프로토콜이다. ex) 편지 배달, 음악이나 동영상 스트리밍 서비스  

<img src="../resource/img/ch1/difference_tcp_udp.png" width="750" height="355" />

## 5. 인터넷 애플리케이션 프로토콜
    * Telnet
      - 원격지 컴퓨터에 접근하기 위한 프로토콜로 TCP 포트 23번을 사용한다.
      
    * FTP(File Transfer Protocol)
      - FTP는 파일을 효율적으로 전송하기 위해 만들어진 표준 프로토콜로 TCP 포트 21번을 기본적으로 사용하며 데이터 전송을 위해 TCP 포트 20번을 사용한다.

    * POP3(Post Office Protocol Version 3)
      - 이메일을 수신하기 위한 표준 프로토콜이다. 메일 서버가 사용자를 대신해 이메일을 수신하고 보관한다. 사용자는 주기적으로 메일 서버에 있는 메일 수신함을 점검하고 수신된 메일이 있으면 자신의 로컬 컴퓨터로 내려받는다. 이와 같이 POP3는 이메일을 수신하기 위한 C/S(Client/Server) 프로토콜이며 TCP 포트 110번을 사용한다.
      
    * IMAP(Internet Message Access Protocol)
      - 사용자의 로컬 컴퓨터에서 이메일에 접근하기 위한 표준 프로토콜로 POP3와 유사한 C/S 프로토콜이다. POP3보다 강력한 점은 사용자가 메일의 제목과 송신자만을 보고 메일을 내려받을 것인지 결정할 수 있다는 점이다. 또한 메일 서버에 폴더나 우편함을 만들어 관리를 할 수 있으며, 메시지를 지우거나 검색할 수 있다. IMAP는 TCP 포트 143번을 사용한다.
    
    * SMTP(Simple Mail Transfer Protocol)
      - 메일을 보내고 받는 데 사용되는 프로토콜로 TCP 포트 25번을 사용한다.
        수신측에서의 큐 메시지 능력의 제한으로 인해, 대개 POP3나 IMAP 프로토콜 중 하나를 쓰는 것이 일반적이다.
        즉, 대부분의 경우 메일을 발신할 때는 SMTP를 사용하고 수신할 때는 POP3나 IMAP를 사용한다.       
    
    * HTTP(HyperText Transfer Protocol)
      - 상태를 유지하지 않는(stateless) 일반적으로 사용되는 프로토콜로 TCP 포트 80번을 사용한다.   
    
    * Finger
      - 메일 주소를 이용해서, 특정 사용자에 관한 정보를 알려주는 데 사용하는 프로토콜로 TCP 포트 79번을 사용한다.
        대부분의 시스템 관리자들은 보안상의 이유로 핑거의 접근을 막아놓는다.
    
    * NNTP(Network News Transport Protocol)
      - 유즈넷 뉴스그룹에 올려진 글들을 관리하기 위해 서버와 클라이언트에 의해 사용되는 프로토콜로 TCP 포트 119번을 사용한다.

## 6. TCP/IP 스택
<img src="../resource/img/ch1/tcp_ip_stack.jpeg" width="500" height="250" />

## 7. 소켓과 포트
> 네트워크를 통해 애플리케이션 계층으로 들어온 데이터를 프로그램에서 인식해서 사용하기 위해 `소켓`과 `포트`를 사용한다.


  * 소켓
    > 소켓에는 전송을 위한 큐와 수신을 위한 큐 한쌍이 있으며, 보통 운영체제의 커널 안에 있는 메모리 영역에 구현된다. 또 특정 포트 하나와 연결해서 애플리케이션과 통신하게 된다.


  * 포트
    > 포트는 하나의 통신 창구로 이미 정해진 번호며, 16비트의 값을 나타낸다.
    
    
    - 포트 번호
       1 ~ 511 : FTP, TELNET, HTTP, SMTP 등과 같은 표준 TCP/IP 애플리케이션용으로 예약되어 있다.
    512 ~ 1023 : 대부분의 운영체제에서 우선권이 있는 프로그램이 사용할 수 있게 예약되어 있다.
    ※ 따라서 표준적으로 사용되는 애플리케이션을 개발할 것이 아니라면 1024 이상의 포트번호를 사용해야 한다. 

<img src="../resource/img/ch1/socket_port.png" width="580" height="366" />

## 8. 보안
> 자산의 본래 가치가 손상되지 않도록 적절한 방법으로 이를 보호하는 것을 의미한다. 인터넷 세계에서의 보안은 해킹(Hacking), 바이러스(Virus) 등으로부터 자산을 보호하는 것이다.

    * 방화벽 시스템
      - 외부의 불법적인 침입으로부터 내부의 정보자산을 보고하고 유해정보 유입을 차단하기 위한 정책과 이를 지원하는 하드웨어 및 소프트웨어를 말한다.
        일반적으로 방화벽 시스템은 시스템과 인터넷 사이에 설치되는 프록시 서버로, 사전에 방화벽 시스템에 등록된 IP 주소만 접근ㄴ이 가능하도록 관리하는 일종의 차단막 역할을 수행한다.
        
<img src="../resource/img/ch1/proxy_server.png" width="460" height="188" />
      
    
## 참고자료
* http://www.blakeleyllp.com/industries.php?area=ElectronicTechnologyCommunications
* http://blog.naver.com/PostView.nhn?blogId=shj1126zzang&logNo=220053175349&parentCategoryNo=&categoryNo=&viewDate=&isShowPopularPosts=false&from=postView
* https://karfn84.tistory.com/entry/network-%ED%8C%A8%ED%82%B7-%EA%B5%AC%EC%A1%B0-ether-tcp-ip-header
* https://shlee0882.tistory.com/110
* http://korean-daeddo.blogspot.com/2015/12/ip.html
* https://namoeye.tistory.com/category/?page=7
* https://ddooooki.tistory.com/21
* https://interconnection.tistory.com/27