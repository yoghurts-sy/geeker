# Geeker thinkPHP
## 设置伪静态
```
  if (!-e $request_filename) {
                rewrite  ^(.*)$  /index.php?s=$1  last;
                break;
            }
```
