# LangChain4j_xiaozhi
尚硅谷小智医疗项目


后端已完成如下升级，安全性大幅提升：
密码加密存储：注册时用 BCrypt 加密，数据库只存加密后的密码，登录时用 BCrypt 校验。
JWT登录认证：登录成功后生成JWT（token），返回给前端，后续可用于接口鉴权。
接口返回结构：注册、登录接口统一返回JSON，包含 success、msg，登录成功还会返回 token。
Spring Security配置：已允许注册、登录接口匿名访问，其他接口后续可按需加权限。
你可以继续用原有前端页面测试，后端接口已兼容原有表单参数，但返回结构已变为JSON。