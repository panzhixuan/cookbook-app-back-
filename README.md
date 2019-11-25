# cookbook 后端
## 记得先配置数据库数据 cookbook.sql
## 后端环境是springboot+eclipse 请自行配置
## application.yml请自行修改参数连接你的本地数据库，如果要打包的线上则无需修改此文件，直接打包成war包或者jar包部署到服务器的tomcat即可
## 测试能否访问可以在浏览器测试也可以使用postman测试，本项目发出全部是post请求
## 图片现在不在后端存储，而是使用阿里的oss对象数据库，请不要在意后端static文件夹下img的图片，如需了解oss对象储存请私聊“潘智轩”



##新增了评分模块ScoreController：
目前实现了一下api：
1.get
2.getAll
3.add
详情可以看代码

##实现了推荐算法：
###调用方式：
cookbook/recommand
###参数：
userId
###返回数据：
目前是cookbookId和推荐度结合的一个字典，例如{"1": 5, "4": 7, "3": 0}，第一个为cookbookId， 第二个为推荐度，数值越高越好。
###需要改进的地方：
速度的优化，评分的维度需要增加，例如考虑点击次数以及收藏等
