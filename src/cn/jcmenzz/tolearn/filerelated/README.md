# 第七章 IO（输入输出）
## 任务 7-1
### 任务描述
编写一个保存书店每日交易记录的程序，使用字节流将书店的交易信息记录在本地的csv文件中。
当用户输入图书编号时，后台会根据图书编号查询到相应图书信息，并返回打印出来。
用户紧接着输入购买数量，系统会判断库存是否充足，如果充足则将信息保存至本地的csv文件中，其中，
每条信息包含了“图书编号” “图书名称” “购买数量” “单价” “总价” “出版社”等数据，每个数据之间用英文逗号或空格分隔，
每条数据之间由换行符进行分割。保存的时候需要判断本地是否存在当天的数据，如果存在则追加，不存在则新建。文件命名格式为“销售记录”加上当天
日期加上“.csv”后缀，如“销售记录20160321.csv”。
### 任务目标
+ 学会分析“保存书店每日交易记录”程序的实现思路。
+ 掌握字节流操作本地文件的方法
+ 掌握ArrayList和StringBuffer的使用，以及异常的处理。
+ 了解csv文件的格式

## 任务7-3
### 任务描述
编写一个模拟文件管理器的程序，实现控制台对文件和文件夹的管理操作。此程序中，当用户输入指令1时，
代表指定关键字检索文件，此时需要用户输入检索的目录和关键字，系统在用户指定的目录下检索出文件名中包含关键字的文件，
并将其绝对路径展示出来。指令2代表指定后缀名检索文件，此时需要用户输入检索的目录和后缀名(可输入由逗号分隔的多个后缀名，来实现同时对不同后缀名文件的检索)，
系统在用户指定的目录下检索出指定后缀名的文件，并将其绝对路径展现出来。指令3代表复制文件/目录，
此时需要用户输入源目录和目标目录，程序执行后会将源目录下的内容复制到目标目录下。指令4代表退出系统。
### 任务目标
+ 学会分析模拟文件管理器程序的实现思路
+ 掌握File类的常用方法
+ 掌握文件遍历的方法和文件名过滤器FilenameFilter的用法
### 实现代码
> taskthree下