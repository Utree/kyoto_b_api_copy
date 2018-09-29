# LINE SCHOOL 2018 のAPI copy
sourcetree の使い方の勉強用です

### MySQL 仮想環境を準備する

```bash
# ./docker-compose.yml からコンテナをビルドする
$ docker-compose build

# コンテナをバックグランドで実行する(1)
$ docker-compose up -d
```

DBの設定は自動で行われ、``mysql/init`` ディレクトリ内の ``.sql`` ファイルが実行されて各テーブルが生成される

``mysql/init`` ディレクトリはコンテナ側の ``/docker-entrypoint-initdb.d`` ディレクトリと同期される

(1) キャッシュを消去して新たにビルドし直す場合、 ``docker-compose up -d --force-recreate --build`` を実行する
