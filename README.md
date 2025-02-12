# MqProject
openjdk-23.0.2、spring-boot 3.4.2


# Kafka 安裝教學

# 步驟 1：下載 Kafka
https://kafka.apache.org/downloads
要下載二進制文件

# 步驟 2：安裝 Java (設定環境變數)
openJDK openjdk-23.0.2
Path C:\Tool\JDK\jdk-23.0.2\bin


# 步驟 3：配置 Zookeeper 、啟動 Zookeeper

# 3-1 設定檔設定 zookeeper.properties
C:\Tool\kafka_2.13-3.9.0\config\zookeeper.properties
指定 ZooKeeper 節點用來存放數據快照 (snapshots) 的目錄位置。
dataDir=C:/Tool/DB/Kafka
port預設2181
clientPort=2181
查看是否已經被占用
netstat -ano | findstr :2181

執行
cd C:\Windows\System32\cmd.exe
# .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties


再次查看是否已經成功啟動
netstat -ano | findstr :2181


# 步驟 4：啟動 Kafka

Kafka 設定檔位置
C:\Tool\kafka_2.13-3.9.0\config\server.properties
Kafka port參數設定(預設9092)
controller.quorum.voters=1@localhost:9093

# .\bin\windows\kafka-server-start.bat .\config\server.properties



# 步驟 5：測試 Kafka

# 5-1 建立一個 Kafka 主題（Topic）：
.\bin\windows\kafka-topics.bat --create --topic test-topic --bootstrap-server localhost:9092
成功會在kafka視窗看到 成功建立的回應


# 5-2 啟動生產者（Producer）以發送訊息：
.\bin\windows\kafka-console-producer.bat --topic test-topic --bootstrap-server localhost:9092
輸入一些訊息（按下 Enter 送出）。

# 5-3 啟動消費者（Consumer）以接收訊息：
.\bin\windows\kafka-console-consumer.bat --topic test-topic --from-beginning --bootstrap-server localhost:9092
可以看到剛才輸入的訊息。




