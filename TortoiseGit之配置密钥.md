# TortoiseGit #

1. TortoiseGit 使用扩展名为ppk的密钥，而不是ssh-keygen生成的rsa密钥；
2. 使用命令ssh-keygen -C "邮箱地址" -t rsa产生的密钥在TortoiseGit中不能用；
3. 基于git的开发必须要用到rsa密钥，因此需要用到TortoiseGit的putty key generator工具来生成既适用于git的rsa密钥也适用于TortoiseGit的ppk密钥。

## 具体配置步骤如下： ##

1. 运行TortoiseGit开始菜单中的puttygen程序 ；
2. 点击“Generate”按钮，鼠标在上图的空白地方来回移动直到进度条完毕，就会自动生一个随机的key；
3. 将上一部中多行文本框的内容全选、复制，并粘贴到git账户的 SSH public key中，这就是适用于git的公钥。
4. 点击上图中的“Save private key”按钮,将生成的key保存为适用于TortoiseGit的私钥（扩展名为.ppk）；
5. 运行TortoiseGit开始菜单中的Pageant程序，程序启动后将自动停靠在任务栏中，图标显示为，双击该图标，弹出key管理列表；
6. 点击上图中的“Add Key”按钮，将第4步保存的ppk私钥添加进来，关闭对话框即可。