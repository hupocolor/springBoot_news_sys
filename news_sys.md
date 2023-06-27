# 新闻系统API
[toc]
## 1	环境变量

### Generated server url
| 参数名 | 字段值 |
| ------ | ------ |
|baseUrl|http://localhost:8080|


## 2	API definition
邮箱: 1525864549@qq.com

## 3	updateUser

> POST  /user/update
### 请求头
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|token|||
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| uid|int32||false||
| uname|string||false||
| upwd|string||false||
| roleid|int32||false||
| roleName|string||false||
### 响应体
● 200 响应数据格式：JSON

##### 接口描述
> 




## 4	register

> POST  /user/register
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| uid|int32||false||
| uname|string||false||
| upwd|string||false||
| roleid|int32||false||
### 响应体
● 200 响应数据格式：JSON

##### 接口描述
> 




## 5	logout

> POST  /user/logout
### 请求头
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|token|||
### 响应体
● 200 响应数据格式：JSON

##### 接口描述
> 




## 6	login

> POST  /user/login
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| uid|int32||false||
| uname|string||false||
| upwd|string||false||
| roleid|int32||false||
### 响应体
● 200 响应数据格式：JSON

##### 接口描述
> 




## 7	updateTopic

> POST  /topic/update
### 请求头
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|token|||
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| tid|int32||false||
| tname|string||false||
### 响应体
● 200 响应数据格式：JSON

##### 接口描述
> 




## 8	addTopic

> POST  /topic/addTopic
### 请求头
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|token|||
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| tid|int32||false||
| tname|string||false||
### 响应体
● 200 响应数据格式：JSON

##### 接口描述
> 




## 9	updateNews

> POST  /news/updateNews
### 请求头
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|token|||
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| nid|int32||false||
| ntid|int32||false||
| ntitle|string||false||
| nauthor|string||false||
| ncreatedate|string||false||
| npicpath|string||false||
| ncontent|string||false||
| nmodifydate|string||false||
| nsummary|string||false||
### 响应体
● 200 响应数据格式：JSON

##### 接口描述
> 




## 10	addNews

> POST  /news/addNews
### 请求头
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|token|||
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| nid|int32||false||
| ntid|int32||false||
| ntitle|string||false||
| nauthor|string||false||
| ncreatedate|string||false||
| npicpath|string||false||
| ncontent|string||false||
| nmodifydate|string||false||
| nsummary|string||false||
### 响应体
● 200 响应数据格式：JSON

##### 接口描述
> 




## 11	addComment

> POST  /comment/addComment
### 请求头
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|token|||
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| cid|int32||false||
| cnid|int32||false||
| ccontent|string||false||
| cdate|string||false||
| cip|string||false||
| cauthor|string||false||
### 响应体
● 200 响应数据格式：JSON

##### 接口描述
> 




## 12	getUserById

> GET  /user/{id}
### 地址参数（Path Variable）
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|id|||
### 请求头
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|token|||
### 响应体
● 200 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| uid|int32||false||
| uname|string||false||
| upwd|string||false||
| roleid|int32||false||

##### 接口描述
> 




## 13	delUser

> DELETE  /user/{id}
### 地址参数（Path Variable）
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|id|||
### 请求头
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|token|||
### 响应体
● 200 响应数据格式：JSON

##### 接口描述
> 




## 14	getUsers

> GET  /user/list
### 请求头
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|token|||
### 请求参数(Query Param)
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|current|||
|size|||
### 响应体
● 200 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| records|array[object]||false||
|⇥ uid|int32||false||
|⇥ uname|string||false||
|⇥ upwd|string||false||
|⇥ roleid|int32||false||
|⇥ roleName|string||false||
| total|int32||false||
| size|int32||false||
| current|int32||false||
| orders|array[object]||false||
|⇥ column|string||false||
|⇥ asc|boolean||false||
| optimizeCountSql|boolean||false||
| searchCount|boolean||false||
| optimizeJoinOfCountSql|boolean||false||
| maxLimit|int32||false||
| countId|string||false||
| pages|int32||false||

##### 接口描述
> 




## 15	getTopic

> GET  /topic/{id}
### 地址参数（Path Variable）
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|id|||
### 响应体
● 200 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| tid|int32||false||
| tname|string||false||

##### 接口描述
> 




## 16	deleteTopic

> DELETE  /topic/{id}
### 地址参数（Path Variable）
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|id|||
### 请求头
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|token|||
### 响应体
● 200 响应数据格式：JSON

##### 接口描述
> 




## 17	getTopicPage

> GET  /topic/page
### 请求参数(Query Param)
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|current|||
|size|||
### 响应体
● 200 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| records|array[object]||false||
|⇥ tid|int32||false||
|⇥ tname|string||false||
| total|int32||false||
| size|int32||false||
| current|int32||false||
| orders|array[object]||false||
|⇥ column|string||false||
|⇥ asc|boolean||false||
| optimizeCountSql|boolean||false||
| searchCount|boolean||false||
| optimizeJoinOfCountSql|boolean||false||
| maxLimit|int32||false||
| countId|string||false||
| pages|int32||false||

##### 接口描述
> 




## 18	getTopicList

> GET  /topic/list
### 响应体
● 200 响应数据格式：JSON

##### 接口描述
> 




## 19	getRoleNow

> GET  /role/now
### 请求头
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|token|||
### 响应体
● 200 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| rid|int32||false||
| roleName|string||false||

##### 接口描述
> 




## 20	getRoleList

> GET  /role/list
### 响应体
● 200 响应数据格式：JSON

##### 接口描述
> 




## 21	getNews

> GET  /news/{id}
### 地址参数（Path Variable）
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|id|||
### 响应体
● 200 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| nid|int32||false||
| ntid|int32||false||
| ntitle|string||false||
| nauthor|string||false||
| ncreatedate|string||false||
| npicpath|string||false||
| ncontent|string||false||
| nmodifydate|string||false||
| nsummary|string||false||

##### 接口描述
> 




## 22	deleteNews

> DELETE  /news/{id}
### 地址参数（Path Variable）
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|id|||
### 请求头
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|token|||
### 响应体
● 200 响应数据格式：JSON

##### 接口描述
> 




## 23	getNewsPage

> GET  /news/getNewsPage
### 请求参数(Query Param)
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|current|||
|size|||
|topicId|||
|keyword|||
### 响应体
● 200 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| records|array[object]||false||
|⇥ nid|int32||false||
|⇥ ntitle|string||false||
|⇥ nauthor|string||false||
|⇥ ncreatedate|string||false||
| total|int32||false||
| size|int32||false||
| current|int32||false||
| orders|array[object]||false||
|⇥ column|string||false||
|⇥ asc|boolean||false||
| optimizeCountSql|boolean||false||
| searchCount|boolean||false||
| optimizeJoinOfCountSql|boolean||false||
| maxLimit|int32||false||
| countId|string||false||
| pages|int32||false||

##### 接口描述
> 




## 24	getHotNews

> GET  /news/getHotNews/{topicId}
### 地址参数（Path Variable）
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|topicId|||
### 响应体
● 200 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| nid|int32||false||
| ntitle|string||false||
| nauthor|string||false||
| ncreatedate|string||false||

##### 接口描述
> 




## 25	getByTopic

> GET  /news/getByTopic
### 请求参数(Query Param)
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|current|||
|size|||
|topicId|||
### 响应体
● 200 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| records|array[object]||false||
|⇥ nid|int32||false||
|⇥ ntitle|string||false||
|⇥ nauthor|string||false||
|⇥ ncreatedate|string||false||
| total|int32||false||
| size|int32||false||
| current|int32||false||
| orders|array[object]||false||
|⇥ column|string||false||
|⇥ asc|boolean||false||
| optimizeCountSql|boolean||false||
| searchCount|boolean||false||
| optimizeJoinOfCountSql|boolean||false||
| maxLimit|int32||false||
| countId|string||false||
| pages|int32||false||

##### 接口描述
> 




## 26	getByKeyword

> GET  /news/getByKey
### 请求参数(Query Param)
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|current|||
|size|||
|keyword|||
### 响应体
● 200 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| records|array[object]||false||
|⇥ nid|int32||false||
|⇥ ntitle|string||false||
|⇥ nauthor|string||false||
|⇥ ncreatedate|string||false||
| total|int32||false||
| size|int32||false||
| current|int32||false||
| orders|array[object]||false||
|⇥ column|string||false||
|⇥ asc|boolean||false||
| optimizeCountSql|boolean||false||
| searchCount|boolean||false||
| optimizeJoinOfCountSql|boolean||false||
| maxLimit|int32||false||
| countId|string||false||
| pages|int32||false||

##### 接口描述
> 




## 27	getComments

> GET  /comment/list
### 请求参数(Query Param)
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|current|||
|size|||
|newsId|||
### 响应体
● 200 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| records|array[object]||false||
|⇥ cid|int32||false||
|⇥ cnid|int32||false||
|⇥ ccontent|string||false||
|⇥ cdate|string||false||
|⇥ cip|string||false||
|⇥ cauthor|string||false||
| total|int32||false||
| size|int32||false||
| current|int32||false||
| orders|array[object]||false||
|⇥ column|string||false||
|⇥ asc|boolean||false||
| optimizeCountSql|boolean||false||
| searchCount|boolean||false||
| optimizeJoinOfCountSql|boolean||false||
| maxLimit|int32||false||
| countId|string||false||
| pages|int32||false||

##### 接口描述
> 



