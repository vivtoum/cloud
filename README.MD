参考资料
====  
* MD文档编写：[创建README.md文件](https://blog.csdn.net/zhao_jing_bo/article/details/68063070)
* 对称性加密：[Spring Cloud Config服务端配置细节(二)之加密解密](https://segmentfault.com/a/1190000011680775)

细节讲解
====
* config地址详解

        /{application}/{profile}[/{label}]/{application}-{profile}.yml
        /{label}/{application}-{profile}.yml
        /{application}-{profile}.properties
        /{label}/{application}-{profile}.properties
        
        访问http://localhost:1201/config-client/dev/master，上面的url会映射{application}-{profile}.properties对应的配置文件，其中{label}对应Git上不同的分支，默认为master。
        所以我们最终访问的配置文件是：config-client服务里面配置的仓库地址uri--》dev配置文件--》master分支的属性文件
