FROM gradle:7.4.2-jdk17 AS build
COPY . .
RUN gradlew build --no-daemon 

# ベースイメージの指定
FROM openjdk:17
# ワーキングディレクトリの設定
WORKDIR /app
# アプリケーションのJARファイルをコンテナにコピー
COPY build/libs/*.jar app.jar
# ポートの公開
EXPOSE 8080
# アプリケーションの実行コマンド
ENTRYPOINT ["java", "-jar", "app.jar"]
