### 环境配置
#### 1. groovy安装和验证（mac）
- 1 官网https://groovy.apache.org/download.html下载最新release版本，解压放到指定目录如/Users/xxx/Library/Android/groovy-2.5.9
- 2 环境变量配置
 
~~~
  vim ~/.bash_profile
  # 按i进入编辑模式，添加进path变量, esc键后输入wq保存退出
  export PATH=${PATH}:/Users/xxx/Library/Android/groovy-2.5.9/bin
  # 生效配置
  source ~/.bash_profile
~~~  
- 3 验证: groovy --version, 输出版本号和系统信息即证明安装配置成功

#### 2. IntelliJ idea安装（略）
