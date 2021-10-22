<?php

namespace app\api\controller\v1;
use app\common\controller\BaseController;

class Hello extends BaseController
{
    // 发送验证码

    public function hello() {
        return "Hello thinkphp!!";
    }
}
