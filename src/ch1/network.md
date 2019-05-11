# 네트워크

## 1. 네트워크와 네트워킹

### 네트워크
> 네트워크 케이블이나 전화선, 무선 링크 등으로 연결되어 동일한 프로토콜을 사용하는 `디바이스`들의 집합

<img src="../img/network.jpeg" width="390" height="360" />
    
### 네트워킹
> 네트워크에 연결된 디바이스들 간의 데이터 전송



## 2. 네트워크 통신 방법
- 주소  
    > 디바이스들은 각자의 고유 주소를 사용해서 서로의 위치를 파악하고 통신한다.
  
- 데이터 전송
    > 패킷 사용
    
        * 헤더: 송신자와 수신자의 주소와 체크섬(checksum), 기타 유용한 정보들을 포함한다.        
        * 바디: 전송할 데이터를 바이트 그룹으로 포함한다.
    
  <img src="../img/packet.jpeg" width="647" height="184" />



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

<img src="../img/osi_7layer.jpeg" width="721" height="364" />



## 4. 인터넷 프로토콜
> 인터넷은 OSI 3계층인 네트워크 프로토콜에 기반을 둔 하나 이상의 네트워크 모임으로서 전세계적인 `TCP/IP 네트워크`며, `IP 주소` 체계와 `IP 프로토콜`을 사용한다. 

### IP(Internet Protocol)
    > IP는 네트워크 계층에 존재하는 프로토콜로서 TCP와 함께 가장 널리 사용되고 있으며 패킷이 상대방에게 안전하게 전송되는 것을 보장하지 않는 즉, 신뢰성 없는 프로토콜이다. 트랜스포트 계층에서 패킷을 안전하게 전달한다는 가정으로 IP는 데이터를 효율적으로 전송하는 것에만 집중하기 때문이다. IP 주소는 32비트 정보로 구성되며, Dot(.)을 구분자로 8비트씩 네 부분으로 나뉜다. 이중 일부는 `네트워크`를 다른 부분은 `호스트`를 나타낸다. 현재의 IP 주소 구조는 낭비가 심해 하나의 네트워크를 좀더 작은 네트워크로 나누기 위해 하위넷(로컬 네트워크)을 사용한다.
        
<img src="../img/ip_address.png" width="500" height="250" />
    
### ICMP(Internet Control Message Protocol)


## 5. 인터넷 애플리케이션 프로토콜


## 6. TCP/IP 스택


## 7. 소켓과 포트


## 8. 보안


## 참고자료
* http://www.blakeleyllp.com/industries.php?area=ElectronicTechnologyCommunications
* http://blog.naver.com/PostView.nhn?blogId=shj1126zzang&logNo=220053175349&parentCategoryNo=&categoryNo=&viewDate=&isShowPopularPosts=false&from=postView
* https://karfn84.tistory.com/entry/network-%ED%8C%A8%ED%82%B7-%EA%B5%AC%EC%A1%B0-ether-tcp-ip-header
* https://shlee0882.tistory.com/110
* http://korean-daeddo.blogspot.com/2015/12/ip.html