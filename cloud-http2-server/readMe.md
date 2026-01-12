## ssl生成语句
keytool -genkeypair \
-alias tomcat \
-keyalg RSA \
-keysize 2048 \
-storetype PKCS12 \
-keystore server.p12 \
-validity 3650 \
-storepass 123456 \
-keypass 123456 \
-dname "CN=localhost, OU=Dev, O=Ryan, L=Local, ST=Local, C=CN"
