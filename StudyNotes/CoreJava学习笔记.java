=====CoreJava-Java简介==================================================================
一、Java发展
	J2SE--J2EE--J2ME
	1995年Java公布1.0，1997年发布1.2版本，2004年发布1.5.  
	特点：①简单（相对于C++）；②平台无关性，跨平台；③纯面向对象。
	运行机制：Java先编译（.java源文件--->.class字节码文件），后解释。
二、环境变量
	1、JVM；Java的虚拟机，用于屏蔽不同OS之间的差异；
	   JRE；Java运行时环境。JRE=解释器+JVM；
	   JDK：Java开发工具包。JDK=JRE+编译器+类库+工具；
	2、环境变量：
		JAVA_HOME:JDK安装目录；
		PATH：JDK的工具命令，设为安装目录下的bin目录；
		CLASSPATH：加载.class文件的目录，设为.（当前目录）；
	3、常用的DOS命令
		回到当前盘符根目录：cd\
		到子目录：cd 子文件夹名
		切换盘符：e:
		到上一目录：cd..
		查看当前目录内容：dir
	4、 创建 jar 文件命令
		把指定的包中的 class 文件打包成 jar 文件
		语法：
		jar cvf jar 文件名 要打包的文件夹
			c：create（ 创建）  v:visible（可视的）  f:filename（文件名 ）
			比如：jar cvf abc.jar ./com
			执行完后在当前目录会生成一个abc.jar的文件，解压后就是com文件夹，里面还是
			class 文件
			cvf:create visible filename 创建可视文件名
			如果在别的 java 文件中要用到此 jar 文件中的类，那么就要在环境变量的CLASSPATH
			中多配一个abc.jar的路径。 然后在类文件中直接import这个类就可以了
	JVM查找类的顺序：
		①当前路径下找类
		②从 rt.jar 中找类（jdk 提供给我们的class）
		③CLASSPATH 设置的路径	
三、结构简介
	①1个源代码中，可以定义多个class，每个class编译后，分别生成对应的class文件；
	②每个class中，最多可以有一个main函数，是应用程序的入口；
	③如果1个源代码中，定义了多个class，允许并且只允许其中1个类是public的；
	  源文件名必须和public的类同名。
	package包：必须是程序的第一行--->编译时：javac -d . 文件名.java
	import语句：导入包，必须在package语句后，在类前；
	例如：导入指定类的全部静态成员、方法
		import static java.lang.System.*；
	注释：//单行注释
		/*
		多行注释
		*/
		/**
		javadoc注释：javadoc XX.java -d 生成文档路径
		*/
【重点】命名规范：
	1) 望文生义
	2) 标识符可是由 字母、数字、下划线和$组成，不能以数字开头；
		不能是java的关键字、保留字。
	3) 类名，每个单词的首字母都大写（帕斯卡命名法）
	变量名，首单词全小写，其后单词首字母大写（骆驼命名法）
	方法名，同变量名，首单词用动词；
	常量名，所有字母都大写。
	包名，所有字母都小写。
	
=====CoreJava-Java语法==================================================================
一、变量
	是一块内存空间，也称为内存地址的别名。包括类型、变量名、值三部分。
	1、定义和使用
		数据类型 变量名; //声明变量
		变量名 =  值;  // 变量赋值
		
		int a;
		a = 5;
		int a = 5;//声明同时，赋初值
		
		int a,b,c;
		a = 3;
		b = 4;
		c = 5;
		
		int a=3, b=4, c=5;
		
		System.out.println(a); //使用变量
	2、注意
		局部变量，必须先声明 赋值，才能使用；
		使用范围：从定义它的位置开始，到定义它的代码块结束。
二、数据类型 
	1、简单类型（原始类型）
		整数类型
		byte	1Byte   -128 到 127
		short	2Byte   -32768 到 32767
		int		4Byte   -2147483648 到 2147483647
		long	8Byte   -2^63 到 2^63-1
		【注意】以上4种类型共用同一组字面值，默认是int类型，
				如果定义为long，必须在其后添加L或l(小写字母)。
				
		小数类型
		float	4Byte	单精度	近似存法，支持科学计数法 1E10 
		double	8Byte	双精度  （3.14e2就是3.14*10的2次方）
		【注意】float和double共用同一组字面值，默认是 double类型，
		如果定义为float，必须在其后添加 F 或 f(小写字母)。
		浮点型数据除以零会得到正无穷大和负无穷大，0.0/0.0或者对负浮点数开方
		会得到非数NaN。
		
		字符类型
		char 	2Byte	unicode编码，字面值：'A' 65 '\u0041'。
							转义字符 '\n' ：换行，'\t'： 制表位， '\\' ：字符\
		布尔类型
		boolean 1byte   字面值：true、false
		【注意】自动类型提升
	2、对象类型（引用类型）
		①属于所有非基本类型的其它类型
		②类型的分类：
			--八种基本类型包装类
			--引用类型
			--空类型（void）
		③在内存中的存储方式
		对象类型的变量实际上存储的是对象所在的内存的地址
		一个对象类型占四个字节， 也就是其最大寻址空间是 4G。
		内存被分为两块空间： 栈空间和堆空间
			--栈：负责给方法分配空间
				main 方法在栈的最下面
				方法里对象的引用也是存在栈空间中的
				存储对象的引用如果是定义在方法体内的也是存在栈中的
			--堆： 给对象分配空间
				对象就相当于一个气球， 引用就相当于栓着气球的绳子
				一个对象可以有多个引用指向它。
				如果一个引用不指向任何对象，那么如果我们去调用这个对象的话，JVM会报给我们
				NullPointException（空指针异常）
三、运算符
	①移位运算符： 只能针对二进制数据（整数）
		<< 左移，左移一位相当于原来的数乘二，大于32位的话高出的位就不要了,如果移动
			的位数大于32的话java会自动把这个位数变为这个数对32求余的值。
		>> 右移，右移一位相当于除2取整，两位相当于连续次除2取整而不是除4取整，看正数
			还是负数，正数右移的话高位补0， 负数的话补1。
		>>> 无符号右移（算数右移），不考虑符号位，移进来的都补0。
	②位运算符
		&按位与，两个数按位与，全部转换成二进制后按位比较，全为1才是1，其他是0。
		|按位或，两个数按位与，全部转换成二进制后按位比较，全为0才是0，其他是1。
		^按位异或，两个数的二进制位数比较， 相同结果为0，相异结果为1。
		~按位求反，把一个数二进制的每一位都反过来（单目运算符）。
	③逻辑运算符
		&& 短路与，如果左边是假的话就不再判断右边的，直接返回假
		|| 短路或，如果左边为真的就不再判断右边的，直接返回真
		& 与，不管怎样两边都会判断， 都为真才返回真
		| 或，不管怎样两边都会判断， 都为假才返回假
	④条件运算符（三目运算符）
		(布尔表达式)?值1:值2
		如果?前面的返回真，那么就执行值1，如果返回假，则执行值2.
	⑤自加和自减
		++ 前++的话属于先加后用， 后++的话先用后加
		-- 前--的话属于先减后用， 后--的话先用后减
		
=====CoreJava-流程控制、分支语句========================================================
	①if(boolean){
			...
		}
	或
	if(boolean){
		...
	}else{
		...
	}
	或
	if(boolean){
		...
	}else if(boolean){
		...
	}else{
		...
	}
	②switch(..){
	case ..:......;
	case ..:......;
		...
	default:....;
	}
	【注意】①switch后括号中的值必须是int，byte，char，short，枚举类型和String类型的变量，其他
			类型的变量不可以使用了。
			②每个case后面的值必须是不相等的，而且必须是常量；
			③如果每个case冒号后面的语句执行完后没有break，还会继续执行后面 case 里的语句，所以
				在每个case的语句结束后加一个 break；
			④default 代表如果和所有case后的值都不匹配，就执行这里的语句。无论 default写哪都
			是最后执行的。
	③System.exit(0);
		--如果系统执行到这条语句的话程序就退出了
	从键盘接收数据：Scanner scan=new Scanner(System.in);
		int sint=scan.nextInt();//读入一个整数
		String str=scan.next();//读入一个字符串，遇到空格结束
		String line=scan.nextLine();//读入一行字符串，在控制台输入之后，按回车键程序才会继续执行
	④for循环语法
		for(1;2;3){
		...
		}
		--写在1的地方是给一个值初始化，2位置的是退出循环的条件，一般是1位置的变量
			到什么程度退出循环，3位置是1位置值的变化，当第一次循环结束后执行一遍 3 位置， 
			然后接着判断 2 的位置的值是真还是假，假就退出，真的话接着循环循环的顺序便是
			1-->2-->循环体内代码-->3-->2-->如果为真继续执行循环体内代码-->为假退出循环
	⑤while循环语法
		while(boolean){
			...
		}
		--每循环一次就判断括号中的代码是不是为真，是真的话就继续循环，假的话就结束循环
	⑥do..while 循环语法
		do{
			...
		}while(boolean);
		--无论如何都会先执行一次再判断条件是否为真，其它的和while循环规则一样
	【注意】如何使用循环：
		1. 是不是一个循环问题（根据实际情况）
		2. 用什么循环语句（for适合循环次数固定的循环；while 适合循环次数不固定的循环；
			do..while适合循环次数不固定并且必须要做一次的循环）
		3. 写出循环的结构（for（；；） {} ； while（boolean） {} ； do{}while（boolean）
		4. 每次循环要做什么（可以先用文字表达出来）
		5. 循环内容转换成java 语句
		6. 分析、 测试
	【控制语句】break；打断循环		continue：结束本次循环，进入下次循环
	
=====CoreJava-数组======================================================================
一、一维数组
	1、声明数组 语法：
		--类型[] 数组名  or 类型 数组名 []
		比如： int[] a 或者 int a[]
	2、声明数组只是声明了一个数组的引用，并没有在内存中给数组开辟空间
	数组是被当作对象来处理的，所以要初始化，语法：
		--类型[] 数组名 =new 类型[长度] 比如： int[] a=new int[10];
	3、遍历数组
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	注意：数组的下标是从0开始的，所以最后一个数组元素的下标为数组长度减1
	4、也可以在初始化数组的时候就给数组赋值
		比如： int a=new int[]{1,2,3,4};//声明了一个长度是4的int数组，
		里面的值为1234，还可以简写为： int a={1,2,3,4};
	注意：只有实例化数组的时候才可以给数组一次性赋值，以后就只能单独赋值了
二、二维数组
	1、声明二维数组 语法：
		--int[][] ia;
	2、实例化 语法：
		--int[][] ia=new int[3][5];//声明了一个三行五列的二维数组
	3、声明时赋值
	4、不规则数组， 也就是每一行数组的长度不一样,声明的时候只指定第一维的下标
		int[][] a=new int[3][];//这样数组定下来是三行， 但是每一行多少长度是未知的
		对每一行实例化：
		a[0]=new int[5];
		a[1]=new int[3];
		a[2]=new int[4];
		那么这样这个数组就成为了一个第一行长度是5，第二行长度是3， 第三行长度是4
		的不规则二维数组
	5、遍历二维数组
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				System.out.println(a[i][j]);
			}
		}
	【注意】存放对象类型数据的数组，每个数组元素存放的都是对象在内存中的地址，都是对象的引用
三、【注意】数组的辅助工具类和方法java.util.*;
	1、 数组常用方法：
		System.arraycopy(myArray, 0,myArray,0, hold.length);
		方法参数从左到右依次原数组，原数组起始位置，新数组，新数组起始位置，新数组长度
		Arrays.copyOf(type[] type,int newLength)
		拷贝数组
		Arrays.copyOfRange(type[] type, int from, int to) 
        将指定数组的指定范围复制到一个新数组，新数组长度为to-from
		Arrays.equals(type[] a, type[] b) 
        如果两个数组彼此相等，则返回true
		Arrays.fill(type[] a, type val)
        将指定的值分配给数组的每个元素。
		Arrays.fill(type[] a, int fromIndex, int toIndex, type val) 
        将指定的值分配给数组指定范围中的每个元素
		Arrays.sort(type[] a);
		将数组按升序进行排列
	2、方法：  
		定义方法（声明及实现）
		声明 ：<modifiers><return type><name>(argument_list)[throws(Exception)]{ block}
		*修饰符可以不要， 修饰符之间的位置可以互换
		*普通方法如果没有返回值的话， 那么返回类型就是 void
		*返回值的类型和定义方法时的返回类型匹配
四、排序
	//选择排序
	for(int i = 0;i<a.length-1;i++){
		for(int j = i+1;j<a.length;j++){
			if(a[i]>a[j]){
				a[i] = a[i]^a[j];
				a[j] = a[i]^a[j];
				a[i] = a[i]^a[j];
			}
		}
	}
	//冒泡选择
	for(int i = 0;i<a.length-1;i++){
		for(int j = 0;j<a.length-1-i;j++){
			if(a[j]>a[j+1]){
				a[j+1] = a[j+1]^a[j];
				a[j] = a[j+1]^a[j];
				a[j+1] = a[j+1]^a[j];
			}
		}
	}
		
=====CoreJava-面向对象==================================================================
一、面向对象编程要解决的本质工作：
		把现实问题抽象成计算机能解决的问题, 对现实问题在计算机中建模（抽象）
		抽象：
			1、对数据的抽象
			2、业务逻辑
		面向对象和面向过程的区别：看以什么抽象为导向：面向对象（以数据的抽象为导向），
									面向过程（以业务逻辑抽象为导向 ） 
		设计思想：“一切皆对象”
		对象-->数据-->类-->数据类型
	各司其职   对象功能简单  简单对象-->复杂系统
	可重用性   
	可扩展性
	弱耦合性   对象间的联系尽可能的弱			
二、类的语法：
		public class 类名 {
			类型 属性名;（成员变量有默认值）
			类型 属性名;
				...
			public void 方法名 (){
				...
			}
			...
		}
	【注意】方法定义和调用时的几个匹配关系：
	①定义时声明的形参类型要和调用时给出的实参类型匹配
	②方法中返回的值的类型要和方法声明中返回值的类型相匹配（如果返回类型不为
		void，那么在方法体中一定要有能运行到的return语句,或者抛出异常返回。）
	③方法的调用语句要和其所处的上下文环境匹配（要有正确的数据类型去接收方法的
		返回值，以及对方法的返回值的正确的操作）
	④方法的递归调用：方法直接或间接的调用它自己，写递归方法时一定要有递归结束的条件。 
	⑤方法的重载（Overload）：同名不同参（ 参数的不同包括类型和顺序）， 方法的调用是通过参数类型
		来决定的， 构造方法也可以重载
	方法调用的四个步骤：
		--首先在栈中给方法开辟空间
		--其次把实参传给方法的形参
		--再次程序跳到被调用方法中执行方法中的代码
		--最后方法中的代码执行完后再跳回主方法
三、创建类的对象的语法：
	类名 对象名 =new 类名 ();
	Animal a=new Animal();
	new 作用：①为对象申请空间②为属性初始化（系统的自动行为，为了使属性在语法上有意义）
			③调用构造方法（程序员来做的）
	对象类型变量:引用  存储的是对象的地址
		简单类型变量: 存值 存数据
		引用变量: 存对象的地址
		参数传递:简单类型参数传值,对象类型参数传引用(形参和实参指向同一对象)
		引用 = null ; 空指针，引用没有指向任何对象
	调用对象的成员
		对象名. 属性名 ;
		对象名. 方法名 ();
		a.name=...;
		a.move();
四、【重点】构造方法：
	用处：
		1、构造方法一般用来为属性赋初值
		2、构造方法会在生成对象时被系统自动调用
	特点：
		1、没有返回值，写返回值的位置什么都不写
		2、方法名必须和类名完全相同
	构造方法也可以定义参数，也可以在里面写实现代码，但是如果一个类中只有一个构造方法， 
	并且这个方法是有参数的，那么在创建类的对象的时候也要传参数。
	如果类里没有写构造方法，在创建对象的时候同样会被虚拟机调用其构造方法，因为：任何类
	都有构造方法，如果程序员不定义，则系统会加上一个缺省的构造方法。
	如果自己定义了构造方法，则系统就不会添加这个缺省的构造方法。
【注意】this 的用法
	在局部变量与外部变量同名的时候，为了区分，就要在外部变量的前面加一个this 来
		表示这个变量是类的全局变量。
	如果在方法中直接使用这个变量的话，那么我们用就近原则，也就是说我们会认为这个
		变量是局部变量
	this 等价于当前对象，调用当前对象的属性或方法就用this.属性名 ，或 this.方法名() 。
	当前对象：指谁在调用当前这个方法和属性，谁就是当前对象。在定义类的时候是不存在
	当前对象的。
	this（argsments_list）：这句话只能出现在构造方法里的第一行，含义：在该构造方法中
	调用本类的其他构造方法，至于会调用那个构造方法， 会根据参数类型来去决定。
【注意】当生成对象时，比如：Animal a=new Animal()时，系统做了三件事：
	1、给对象在堆中分配空间 属性有默认值
	(1)有父类的话，构造父类对象
	2、给对象的属性初始化   属性初始值
	3、调用构造方法			属性被赋予构造参数

=====CoreJava-三大特性==================================================================
一、封装：
	如果一个数据类型，把它不想让外部知道的属性和方法私有化，把它能让外部访问的属
		性和方法公共化，这就叫封装。
	属性最好是被封装在内部的， 因为这样公开自己内部信息的主动权就在自己身上。
	属性的隐藏不是最终目的，是为了让外部更好的、更安全的去访问。
	定义访问方法：setXXX(),getXXX()
		访问的方法格式是固定的
		获得属性值的方法必须返回类型是属性的类型，方法名为get属性名()
		设置属性值的方法参数类型必须是属性的类型，方法名为set属性名(属性类型变量名) 
	封装的好处：代码维护方便，如果属性名变了，其它程序根本不用做改动，还是调用这
		个控制属性的方法就行了
二、 继承（代码重用）
	1、语法-->public class 子类名  extends 父类名{ ... }
	2、子类的对象可以调用父类的一切公有的属性和方法，也可以扩展自己新的属性和方法，
		但是新扩展的部分父类的对象是无法调用的
	3、super(..,..)的用法，在子类的构造方法中调用父类的构造方法，并且super要放在第
		一行，不能与this一起用，主要用为在构造子类的时候给父类中定义的变量赋值
	4、子类的一些特点
		--任何子类的构造方法都会调用父类的构造方法
		--任何子类的构造方法的第一行必须是this(..)或super(..)的调用，如果程序员不写， 
		  则系统会隐含的调用super()也就是说，子类不管怎样一定会调用父类的构造方法
	5、为什么子类的构造方法一定要调用父类的构造方法呢
		因为如果构造了子类的对象就一定要构造父类的对象，从反方向来讲，虚拟机会先创造
		一个所有类的父类对象出来， 然后再对这个对象扩展，最后生成子类对象。
	6、构造了一个子类对象其实也只是创建了一个对象，只不过父类对象是子类对象的一部分。
	7、如果父类的属性和子类的属性同名的话，首先来说，现实中不会有这样的需求，完全没
		有必要在子类中定义与父类同名的属性。如果确实定义了的话，直接用name或者 
		this.name就是调用的子类的（就近原则），要想调用父类的就要super.name
		或super.getName();
	8、如果父子类中有同名的方法，如果同名不同参，只是一种重载；如果是同名同参的话，
		那子类对象调用的这个方法便是子类自己的，这种子类与父类存在同名同参的方法的
		形式叫做方法的覆盖（Override），也就是子类的方法把父类的覆盖了 。
【注意】方法覆盖的原则：
		--发生在父子类之间
		--同名，同参，同返回类型
		--子类方法的修饰符不能比父类方法的修饰符更封闭
		--抛出异常类型不能更宽泛
三、 多态（子类对象可以赋值给父类引用）
	1、方法的覆盖就是方法多态的一种体现
	2、对象的多态，一个对象多种形态，这要取决于对象的继承关系
	3、表现对象多态的一种形式，把子类对象当作父类对象的一种形式，但是此对象
		不能调用父类中没有的方法
	4、多态定理：
		--如果我们把子类对象当作父类对象来看， 那么就只能访问父类中
			已有定义的属性和方法（不能访问子类扩展的属性和方法）
		--如果子类覆盖了父类的方法，再把子类对象当作父类对象去调用该方法时，调用的是
			子类覆盖后的方法。（对象的行为不可能因为你把它当作什么来看而改变）
【注意】instanceof，判断一个对象是不是某一个类型的实例。
用法--->对象名 instanceof 类名; 返回一个布尔值，如果前者是后者的实例则返回真
并不是所有的父类都能转换成子类如果任意强转不匹配的类型就会抛出
java.lang.ClassCastException类型转换异常：把一个原本不是这种类型的对象强转成这种对象

=====CoreJava-修饰符====================================================================
一、访问控制修饰符：
	public：公共的，如果用这个修饰属性和方法，则这个属性和方法能在任何地方被调用。
	protected：受保护的
	default（什么都不写）：
	private：私有的，如果用这个修饰属性和方法，则这个属性和方法只能在类的内部被使用。
	修饰符的作用：封装类
二、static（属性，方法，代码块）描述整体特征而不是个体特征的属性时，用静态修饰符
	--静态和非静态的差别
		1、空间分配时机：
			静态变量是在类加载的时候分配空间， 非静态对象是在生成对象的时候分配空间
		2、空间分配方式：
			不管有多少对象静态变量只有一份（所有对象共用）， 非静态变量有多少对象就
			分配多少个空间
		3、访问方式：
			静态变量是：类名.属性，比如 Animal.COUNT
			非静态变量：对象名.属性，比如 a.name
	--静态方法和非静态方法的区别
		1、 静态方法是通过类名来调用，非静态方法是通过对象来调用
		2、 静态方法中不能访问本类的非静态成员，但非静态方法可以访问静态成员
【注意】为什么主方法非要是静态的：
			我们看执行java Test命令后的运行步骤
				1、启动 JVM
				2、找到 Test.class
				3、加载 Test.class
				4、Test.main();
	也就是说main方法是程序的入口，那么在执行 main 方法之前是执行不了任何代码的，所以获得不
了这个类的对象，只有用这个类的类名来调用main方法，所以main方法必须为static
	--静态代码块
		1、 静态代码块会在类被加载时被系统自动执行
		2、 一般可以在静态代码块中给静态属性赋值
	--静态方法不存在多态特性，也就是静态方法无法被子类覆盖，父类对象调用此方法还
		是父类的所以虽然静态方法可以被对象调用，但也不要这样用，要用类名对其进行调用
	--实例代码块
		1、系统在生成类的对象式执行该代码块
		2、一般可以把一些生成实例时做的事放在该代码块里。
【注意】加载类的几种情况（一个类在整个程序运行过程中只会加载一次）：
		1、生成一个对象
		2、访问类的静态成员
		3、特殊语法（如：Class.forName（））
	不会加载类的情况：
		1、定义该类的一个引用（Animal a；）
三、final（类，属性，方法，局部变量）
	1、修饰属性：属性不可变，并且属性在声明的时候必须初始化，或者在构造方法中初
		始化，一般与static一起用，一旦定义了，就不能再变了 。
	2、修饰方法：方法不能被覆盖
	3、修饰类：类不能被继承
	4、修饰局部变量：局部变量不可变（常量）
四、abstract（抽象）
	1、用来修饰类和方法。
	2、修饰类的话表示这个类是个抽象类，抽象类不能被实例化（生成对象）。
	3、修饰方法的话表示这个方法是个抽象方法，抽象方法没有方法体。
	4、如果一个类包含有一个抽象方法，那么这个类必须是抽象类。
	5、如果一个类不包含抽象方法，那么该类也可以被定义成抽象类。
	6、抽象类不能被实例化，但却可以定义引用。
	7、抽象类一般需要被继承--定义一个类，并实现抽象方法。
	8、抽象类也是有构造方法的，因为需要被子类调用。
	9、子类必须实现父类的抽象方法（即覆盖父类的方法）。
【注意】private static final都不能和abstract联用

=====CoreJava-类相关====================================================================
一、接口  特殊的抽象类
	interface 接口；implements 实现
	1.所有的方法都是公开抽象方法   public abstract 
	2.所有属性都是公开静态常量     public static final
	3.没有构造方法

	一个类实现接口,如果这个类不希望成为抽象类,就必须实现接口中所有的方法

	接口之间可以多继承，一个类在继承另外一个类的同时,还可以实现多个接口

	接口的作用
		1.多继承  
		2.标准  将标准的使用者和标准的实现者分离 解耦合
		接口回调 (A--->I---B)  由程序员负责写B类,实现接口,不用关心A类
二、内部类
	在不破坏封装的基础上,访问外部类的私有成员
	成员内部类
	静态内部类
	局部内部类    作用范围从定义开始,到所在的代码块结束
				不仅可以访问外部类的私有成员,还可以访问外部类的局部常量(final)
	匿名内部类    特殊的局部内部类
		1.继承某个类或者实现某个接口
		2.只会创建一个对象  	
三、Object类
	【注意】JVM内存空间:
		堆:对象   new
		栈:局部变量  
		代码空间:静态变量  其他数据(常量池)
	Object是Java所有类的父类
	1. Object o:存储任何对象
	2. Object类中的公开或受保护的方法是所有Java对象都具有的方法

	final getClass(): 获得对象的实际类型，判断引用是否存储了同一类的对象 a.getClass()==b.getClass()
	finalize(): 在对象被垃圾回收时,由垃圾收集器自动调用
        垃圾对象判定: 零引用
        垃圾收集时机: 当JVM存储空间耗尽时,一次性释放垃圾对象
	public String toString():返回对象的字符串形式 String
    public boolean equals(Object o) :判断两个对象的内容是否相同
	== : 判断两个引用是否指向同一对象 判断地址
四、String类
	toCharArray():转成char[]
	String(char[]):利用char[]构造String  

	charAt(int index):返回index下标的字符
	length():长度
	toUpperCase():转为大写
	toLowerCase():转为小写
	contains(String str):判断字符串中是否包含str子串
	indexOf(String str):获得str子串在String中首次出现的位置
	indexOf(String str,int start):获得str子串在String中start下标之后首次出现的位置
	startsWith(String str) :判断字符串是否以子串str开头
	endsWith(String str):判断字符串是否以子串str结尾
	substring(int start,int end):获得子串,包含起始下标,不包含结束下标
	replace(String old,String news) 用news子串替换old子串
	trim():去掉String前后的空格,换行符
	split(String str):以str为分隔符,把字符串拆分为String[]
	toCharArray():将此字符串转换为一个新的字符数组。

字符串内容不可改变, 对象共享 : 串池
	intern():返回字符串在串池中的地址  s = s.intern();把字符串放入串池
	StringBuilder 内容可变 用于字符串连接
	append() 字符串追加
五、包装类
    8种基本类型各自提供一个类表示对象形式
    【重点】Integer Character Byte Short Long Float Double Boolean 
    ①String <---> int
      int i = Integer.parseInt(s);
	  String str = i+" ";//String.value(i);
	②String<--->Integer
	Integer引用.toString();返回字符串
	Integer.valueOf(String str);返回包装类
六、枚举类型
	--什么叫枚举？
		比如一年的季节， 一周中的七天， 都是固定的， 依次出现的
	--枚举用来限制一定得取值范围
	--定义声明枚举类型语法：
	public enum Season{
		SPRING,
		SUMMER,
		AUTUMN,
		WINTER;
	}
	上面声明了一个枚举类型 Season，也可以把枚举看作一个类。
	枚举里可以定义属性，构造方法，但是都必须定义成私有的，也可以定义方法， 修饰符无限制 
	注意：1）默认父类是java.lang.Enum, 而且不可改
		  2）枚举类对象可以用在switch结构中	
		  
=====CoreJava-集合框架==================================================================
集合框架（接口+类） java.util
一、Collection 元素是Object	
	add(Object o):把元素放入集合
	addAll(Collection c):把c中所有元素放入集合
	clear():清空集合
	remove(Object o):删除元素
	size():集合长度
	contains(Object o):判断集合中是否有元素o
二、List 元素有顺序，有下标，可以重复
	add(int pos , Object o):把o添加到pos下标
	remove(int pos):删除pos下标的元素
	get(int pos):获得pos下标的元素
	indexOf(Object o):获得o在集合中的下标
	遍历：①下表遍历；②foreach遍历
	实现类：1.ArrayList    数组实现    查询快,增删慢   1.2  线程不安全 快
			2.LinkedList   链表实现    查询慢,增删快
			3.Vector       数组实现                    1.0  线程安全 慢
			4.Stack        Vector的子类		后进先出（LIFO）  栈
			构造方法：Stack() 创建一个空堆栈。
				empty()		测试堆栈是否为空。
				peek()		查看堆栈顶部的对象，但不从堆栈中移除它。
				pop()		移除堆栈顶部的对象，并作为此函数的值返回该对象。
				push(E item)	把项压入堆栈顶部。
				search(Object obj)		返回对象在堆栈中的位置，以1为基数。返回值-1表示此对象不在堆栈中。
	java.util.Collections工具类
		sort(List list):对list排序
		reverse(List list):对list倒序
		shuffle(List list):对list随机乱序
		synchronizedList(List list):获得一个线程安全的List
三、Set 元素无顺序 无下标  元素内容不可重复
	实现类:
	1.HashSet 将自定义的对象放入HashSet,为了保证元素不重复,必须
		1)覆盖hashCode方法,保证相同对象返回相同的int（尽量保证不同对象返回不同的int）
		2)覆盖equals方法,保证相同对象比较结果为true
	2.LinkedHashSet：HashSet的子类  维护元素进入集合的顺序
	3.TreeSet 实现了SortedSet(Set的子接口)接口  对元素自动排序
四、Map 元素是键值对(key -- value)  key:无顺序，内容不可重复 value:可以重复
	常用方法:
	put(Object key,Object value):把key-value放入Map.如果key已存在,新的value覆盖旧value
	remove(Object key):删除key所对应的键值对
	get(Object key):通过key获得对应的值，如果key不存在,返回null
	clear():清空
	size():长度
	containsKey(Object key):判断key是否存在
	containsValue(Object value):判断value是否存在
	
	遍历:
	keySet():返回Map中所有的key     Set
	values():返回Map中所有的value   Collection
	entrySet():返回Map中所有的entry集合 getKey()/getValue();
	
	实现类:
	1.HashMap   1.2 线程不安全 快   允许用null作为key或value
	2.LinkedHashMap HashMap的子类 维护元素进入Map的顺序
	3.TreeMap 实现了SortedMap(Map的子接口) 自动对key排序
	4.Hashtable 1.0 线程安全 慢    不允许用null作为key或value
	5.Properties  Hashtable的子类  键和值都是String  用于读取和处理配置文件
		load() 放入集合
		getProperty(" ") 获得值对象
	集合中的泛型:约束集合中元素的类型   访问元素时,避免强制类型转换
	
=====CoreJava-异常处理（提高容错性）====================================================
异常的分类
	Throwable
		|- Error 错误  底层错误  无法避免  无法处理
		|- Exception 异常   可以处理 
			|- RuntimeException子类    未检查异常  可以避免  可处理可不处理
			|- 非RuntimeException子类  已检查异常  无法避免  必须处理
异常的产生和传递
	throw : 抛出一个异常    throw 异常对象，沿着方法调用链反向传递

异常的处理:
	1.声明抛出 throws    throws 已检查异常类名
	2.捕获异常 try - catch  

	try{
	}
	catch(异常引用 ){
	}
	必须先catch子类异常,再catch父类异常
	
	try-catch
	try-catch-finally    finally:无论如何都会执行  往往用于释放资源
	try-finally

	printStackTrace():将异常栈追踪信息输出至标准错误流（即System.err）
	getMessage():返回详细的错误信息字符串；

【注意】自己写个类，继承Exception或者是RuntimeException。一般定义为未检查异常，可做处理，也可不处理。
如例子：
	public class MyException extends RuntimeException {
		public MyException(){}
		public MyException(String message){
			super(message);
		}
	}
	
======CoreJava-多线程Thread/Runnable和synchronized======================================
一、单线程：单一顺序的执行流，从 main方法开始顺序执行完主方法中的代码。
	多线程：一个程序中包含有多个执行流（ 批量的轻量级进程）。
	线程与进程的区别： 每个进程都有一个主线程，同时可以建立另外的线程。=
	进程：一个应用程序就是一个进程，它可能包括很多个线程
	线程：一个独立执行的流程
	线程的三要素：CPU data code
		CPU:何时去做（程序中不管它）（不可控制的）
		DATA:谁去做（可共享）
		CODE：做什么（ 可共享）（其实也不需要做过多的考虑，相当于两个独立的线程。
			只不过他们之间是交替执行的。）
			
二、怎样在 Java 中写多线程程序：
1. extending the class Thread
	写一个类继承自Thread，覆盖run()方法
2.implements the interface Runnable【】
	实现Runnable接口，实现run()方法，再用线程类包装这个实现类。public void run()；

三、线程的一些常用方法：（java.lang.Thread 类下）
	1.getId() 返回该线程的标识符。
	2.getPriority() 返回线程的优先级。
	3.currentThread() 返回对当前正在执行的线程对象的引用
	4.isDaemon() 测试该线程是否为守护线程（后台服务线程，如果这个程序中所有
					的非服务线程，也就是前台服务进程都终止了，那么这个线程就终止了 。）。
	5.getName() 返回该线程的名称。
	6.sleep(long millis) 在指定的毫秒数内让当前正在执行的线程休眠（暂停执行）
	7.start() 使该线程开始执行， Java 虚拟机调用该线程的 run 方法。
	8.yield() 暂停当前正在执行的线程对象， 并允许其他线程执行。

四、多线程数据(data)共享的安全问题：(加锁) synchronized
	synchronized(this){//这里的 this 在多个线程中必须为同一个对象才能锁住。
		……
	}
	//这里的this相当于一个boolean值，当他的值为 false，相当于没有被锁住，其他的线程
	//就可以进去。当他的值为 true 时，相当于被锁住了，其他的线程就不能进入。
	//【】特别注意，在这里多线程执行时，如果第一个线程被释放了，那么第二个线程就接着第一
		个synchronized 中断处执行。
	//synchronized 也可以修饰方法。
		public static synchronized void m1(){
			//注意静态方法没有this，这时这种锁叫类锁。
		}
	//为了提高效率， synchronized 的作用范围应该尽量的小。
	wait() 方法， 由对象调用：
		--让当前正在执行的线程释放掉 xx 对象的锁
		--当前正在执行的线程进入到 XX 对象的等待池去等待
		wait()方法的调用必须在被锁的代码中执行，调用 wait()的对象必须是被锁的对象
	notify()方法，随机唤醒该对象的一个线程
	notifyAll() 唤醒该对象的所有线程，被唤醒的线程进入锁池中等待获得锁标记
	
=====CoreJava-IO流======================================================================
一、java.io.File类，文件类，关联磁盘上文件的类
	--构造方法
		File(String pathname)，pathname可以是磁盘上一个文件，也可以是一个目录
	--方法
		createNewFile()，假如在构造方法中的文件不存在，就创建一个此名字的文件
		mkdir()/mkdirs()，创建目录
		delete()，删除指定文件
		exists()，判断文件是否存在
		isFile()，判断是否是文件
		isDirectory()，判断是否是目录
		getName()，返回指向对象的名称
		String getAbsolutePath()，得到绝对路径的字符串
		File getAbsoluteFile() ，返回此文件的绝对路径文件对象
		File[] listFiles()，返回一个抽象路径名数组，表示此抽象路径名表示的目录中的文件。 
		
二、 数据的读写流分类
	--按方向
		输入流： 把内容从外部读到内部		Input
		输出流： 把内容从内部输出到外部		Output
	--最小读写单位：
		字节流：（二进制文件）
		字符流：（文本文件）
	--按层次：
		底层低级流（节点流）：直接对应数据的来源和数据的目的地
		上层高级流（包装流）：建立在节点流之上的流
		
三、(abstract) InputStream/OutputStream字节流

	FileInputStream输入流，字节流，底层流
	--方法
		int read(); 读取一个字节，返回读取字节的值，读完返回-1
		int read(byte[] b); 读取字节，放到数组中，返回读取的字节数，读完返回-1
		int read(byte[],int form,int len); 读取字节放到数组中，从from开始放，最len个，返回读取的字节数，读完返回-1
		void close(); 关闭字节流
		int available(); 是否还有字节可读取，返回下次读取可读取的字节数，如果没有，返回-1
		
	FileOutputStream输出流，字节流，底层流
	--方法
		void write(int b) 把int值的第一个字节写到流中
		void write(byte[]) 把数组中所有字节都写到流中
		void write(byte[],int,int) 从第几个开始，写多少字节往数组中
		void close(); 关闭流
		
四、包装流（过滤流）
	1、DataInputStream/DataOutputStream---->读写基本类型
		过滤流的使用分为下面四个步骤：
		①创建节点流。这个步骤是使用过滤流的先决条件，由于过滤流无法直接实现数据传
			输功能，因此必须先有一个节点流，才能够进行数据传输。
		②封装过滤流。所谓的“封装”，指的是创建过滤流的时候，必须以其他的流作为构造
			方法的参数。需要注意的是，可以为一个节点流封装多个过滤流。
		③读/写数据。
		④关闭外层流。这指的是，关闭流的时候，只需要关闭最外层的过滤流即可，内层流
			会随着外层流的关闭而一起被关闭。
			
	2、BufferedInputStream/BufferedOutputStream--->缓冲流（包装流）
		void flush();刷新释放缓冲区		
		
	3、PrintStream打印流
		PrintStream作为过滤流，增强的功能有以下几个：
			1、缓冲区的功能
			2、写八种基本类型和字符串
			3、写对象
		需要注意的是，这个流写基本类型和写对象的时候，是按照字符串的方式写的。也就是
		说，这个流写八种基本类型的时候，会把基本类型转换成字符串以后再写，而写对象的时候，
		会写入对象的 toString()方法返回值。
		【注意】System.out对象，这就是一个PrintStream类型的对象。	
		
	4、ObjectInputStream/ObjectOutputStream--->对象流：
		Object readObject() 从ObjectInputStream 读取对象(覆盖toString),遇到异常时即读完; 
		void writeObject(Object obj) 将指定的对象写入ObjectOutputStream。
	
		要想让对象通过流传输，对象所属的类必须实现可序列化；implements Serializable
		Serializable//可序列化，标记接口 ，只是标明具有某些特征，不需要实现什么方法；
		对象的序列化，传到文件中，或传到另外一个机器上；写出去的是属性的值；
		private static final long serialVersionUID = 1982237623525024404L;//静态常量，
		值可以自己指定，保证每个类的uid不同就行；属性类型和属性名不能变；
		transient//关键字，瞬时的； 告诉虚拟机这个属性不参与序列化，
五、字符流：其实是一种包装流，对字节数据做了包装--->Reader和Writer结尾的类，都是字符流的类。
		1、FileReader/FileWriter：文件字符输入/出流
		2、InputStreamReader/OutputStreamWriter 桥转换是字符流，可以将字节流包装为字符流；
【注意】利用桥转换进行编程，需要以下五个步骤：
	1、 创建节点流
	2、 桥转换为字符流
	3、 在字符流的基础上封装过滤流
	4、 读/写数据
	5、 关闭外层流
		FileInputStream fi=new FileInputStream("poem2.txt");//创建节点流
		InputStreamReader ir=new InputStreamReader(fi,"gbk");//桥转换为字符流
		BufferedReader in=new BufferedReader(ir);    //封装字符流
			BufferedReader有个public String readLine()，按行读入，读完时返回null
		FileOutputStream fo=new FileOutputStream("poem2.txt");
		OutputStreamWriter ow=new OutputStreamWriter(fo,"gbk");
		PrintWriter out=new PrintWriter(ow);
			println()
【注意】PrintWriter 是一个很特殊的类。
		PrintWriter可以作为一个过滤流。这个流可以接受一个Writer作为参数。增强了如下一些功能：
			1、 缓冲区的功能。因此使用 PrintWriter 应当及时关闭或刷新
			2、 写八种基本类型和字符串的功能。
			3、 写对象的功能。
			
======CoreJava-反射和注释===============================================================		
一、反射（Reflection），Java的基因技术允许程序在运行时透过Reflection APIs取得任何一个
	已知名称的class的内部信息。
	java.lang.Class 类，对象称为类对象
	怎样获得某个类的Class对象：
		--通过调用Class.forName("类名")。这里的类名包括：类、接口、Enum、Exception且全限定名
		--类名.class如：Animal.class int.class（基本类型只能通过类型名.class 来获得类对象。）
		--对象名.getClass();如：Animal a=new Bird(); a.getClass();实现类使用
	【注意】getClass()方法也是Object类的方法,但是这个方法是final型的，不能被覆盖。
	类对象常用方法：
		getName(): 获得类的名称，包括包名
		getSimpleName(): 获得类的名称，不包括包名
		getSuperClass(): 获得本类的父类的类对象
		getInterfaces() : 获得本类所实现的所有接口的类对象，返回值类型为 Class[]
		
		public Method[] getDeclaredMethods() throws SecurityException 包括自己所有的方法
		public Method[] getMethods() throws SecurityException 包括所有的公开方法，也包括父类中定义的公开方法，不包括私有方法。
		Object o=c.newInstance(); 创建一个类的对象；
		
		
二、Field类  java.lang.reflect反射包
	Field 类封装了属性信息，一个Field对象封装了一个属性的信息。
	获得Filed对象：利用Class类的方法
		Field getDeclaredField(String name)	 获得自己及从父类继承的公开属性，无法获得非公开属性
		Field getField(String name)  获得本类所有属性，包括本类的非公开属性。

	修改属性值
	public public void set(Object obj, Object value) 第一个参数表示要修改属性的对象，第二个参数表示属性值要修改成什么。
	public Object get(Object obj) 参数表明要读取哪一个对象的属性。返回值表明读取到的属性值。
	
	【重点】public void setAccessible(boolean flag) 修改私有属性前调用，flag = true(忽略访问限制检查)；
	
三、Method类
	public Method getMethod(String name,Class[] parameterTypes)可以获得公开方法，包括父类的。第一个参数是一个字符串参数，表示的是方法的方法名。
		第二个是参数表(Class数组)，例如new Class[]{int.class，double.class}
	public Method getDeclaredMethod(String name,Class[] parameterTypes) 只获得本类的所有方法
	
	利用反射，调用对象的方法
	首先我们必须获得即将被调用的方法所对应的Method对象，然后对Method对象调用invoke方法。
	invoke 方法签名如下（不包括抛出的异常）
		public Object invoke(Object obj, Object[] args)
			
	在这个方法中，invoke 方法有两个参数
		1、第一个参数 obj 表示对哪一个对象调用方法
		2、第二个参数表示调用方法时的参数表
		3、invoke 方法的返回值对应于 Method 对象所代表的方法的返回值。
			
四、Constructor类封装了构造函数的信息，一个对象代表了一个构造函数。
	--通过Class类中的getConstructors()/getDeclaredConstructors()获得Constructor数组。
	--通过Class类中的getConstructor()/getDeclaredConstructor()来获得指定的构造方法。
		与getMethod不同，这两个方法只有一个参数：一个Class数组。原因也很简单：构造方法的方法名与类名相同，不需要指定。
	--调用Constructor类中的newInstance()方法创建对象。创建对象的时候，会调用相应的构造方法。
五、Annotation, 标注
	--@Deprecated：标注一个方法的话表示这个方法是个过期的方法
	--@Override：标注一个方法的话表示这个方法一定是覆盖父类的一个方法
	--@SuppressWarnings：忽略方法中的警告，标注的的时候要传个参数，参数是个 String[] 对象， 
		此数组的每个元素就是要忽略的类型的警告，这些警告类型的元素在dos命令提示符下用
		javac -X 命令可以查出。
		例如：@SuppressWarnings({"deprecation","unchecked"})
				deprecation是忽略调用过期方法的警告
				unchecked是忽略安全检查的警告，就像声明集合没带泛型
				
【自定义标注】--语法：
			修饰符 @interface 标注名 {
			}
			public @interface Author{}
	-- 标注体里可以定义参数的类型
		8种基本类型、String、Enum、Class、以及这些数据类型的数组
	--标注体里定义参数String value();
		上面是单值标注，定义了一个String类型的参数，参数名是value，前面也可以加上访问控制
		修饰符，单值标注的参数名必须是value，多值标注可以写其他的名字
	--元标注--->用来标注标注的标注：标注自己定义标注的一些特征
		JDK中有四种元标注，在java.lang.annotation包中，使用的话要导入包，写在自
		己声明的标注之上，
		--@Documented：表示标注的信息可以被javadoc这些工具提取出来
		--@Inherited：表示此标注可自动被继承，也就是标注了一个类，那这个类的子类也
						会被自动标注以上两个元标注是标记标注
		--@Retention：用来指定这个标注在多长时间内是有效的，是单值标注，参数类型是RetentionPolicy
		--@Target：指定此标注能够用来标注什么程序元素
	--标注的解析
		--所有标注默认的父接口是Annotation
		--获得某元素标注的方法，比如获得方法的指定标注就是method.getAnnotation(指定
			标注的Class对象)
		--获得标注对象后就可直接调用标注内的属性来返回属性值

=====CoreJava-网络编程==================================================================
1.网络基础知识
2.TCP Socket【重点】
	*TCP是Tranfer Control Protocol的简称，是一种面向连接的保证可靠传输的协议。
	通过TCP协议传输，得到的是一个顺序的无差错的数据流。
	*发送方和接收方的成对的两个socket之间必须建立连接，以便在 TCP 协议的基础上进
	行通信，当一个socket（通常都是server socket）等待建立连接时，另一个socket可以
	要求进行连接，一旦这两个socket连接起来，它们就可以进行双向数据传输，双方都可以进行发送或接收操作。
	1)服务器分配一个端口号，服务器用accept()方法等待客户端的信号，信号一到打开socket 连接，
		从socket中取得OutputStream和InputStream。
	2)客户端提供主机地址和端口号使用socket端口建立连接，从socket中取得OutputStream和InputStream。
	*TCP Socket 编程步骤
	(1)建立 TCP 服务器端
		1).创建一个ServerSocket		ServerSocket ss = new ServerSocket(9000);
		2).从 ServerSocket 接受客户连接请求
		3).创建一个服务线程处理新的连接
		4).在服务线程中， 从 socket 中获得 I/O 流
		5).对 I/O 流进行读写操作， 完成与客户端的交互
		6).关闭 Socket
	(2)建立 TCP 客户端
		1).创建Socket		Socket s = new Socket("150.236.56.101", 9000);
		2).获得 I/O 流		s.getInputStream()
		3).对 I/O 流进行读写操作， 完成与服务器端的交互
		4).关闭 Socket
3.UDP Socket（非重点）
	*UDP 是 User Datagram Protocol 的简称， 是一种无连接的不能保证可靠传输的协议。
		1)DatagramSocket（邮递员）：对应数据报的 Socket 概念，不需要创建两个socket，
		不可使用输入输出流。
		2)DatagramPacket（信件）：数据包，是 UDP 下进行传输数据的单位，数据存放在字
		节数组中， 其中包括了目标地址和端口以及传送的信息.
	*UDP Socket 编程步骤
	(1) 创建一个 UDP 的发送方
		1).创建一个 DatagramPacket，其中包含发送的数据和接收方的 IP 地址和端口号。
		2).创建一个 DatagramSocket， 其中包含了发送方的 IP 地址和端口号。
		3).发送数据
		4).关闭 DatagramSocket
	(2) 创建一个 UDP 的接收方
		1).创建一个 DatagramPacket， 用于存储发送方发送的数据及发送方的 IP地址和端口号。
		2).创建一个 DatagramSocket， 其中指定了接收方的 IP 地址和端口号。
		3).接收数据
		4).关闭 DatagramSocket
4.URL
	*概念：统一资源定位器。
	*格式：协议名 ://主机名 ＋ 端口号＋ 文件名 例： http://www. test.com.cn:21/test/index.jsp
	URL url = new URL("http://www.3.cn");
	//调用 URL 对象的 openConnection 方法，获得 URLConnection
	//URLConnection conn = url.openConnection();
	//调用 URLConnection 方法的 getInputStream
	
//	InputStream in = conn.getInputStream();
	InputStream ips = url.openStream();
	Reader read =new InputStreamReader(ips);
	BufferedReader bis = new BufferedReader(read);
	
===CoreJava-正则表达式和Date类==========================================================
【】正则表达式：
字符 
x 字符 x 
\\ 反斜线字符 
\0n 带有八进制值 0 的字符 n (0 <= n <= 7) 
\0nn 带有八进制值 0 的字符 nn (0 <= n <= 7) 
\0mnn 带有八进制值 0 的字符 mnn（0 <= m <= 3、0 <= n <= 7） 
\xhh 带有十六进制值 0x 的字符 hh 
\uhhhh 带有十六进制值 0x 的字符 hhhh 
\t 制表符 ('\u0009') 
\n 换行符 ('\u000A') 
\r 回车符 ('\u000D') 
\f 换页符 ('\u000C') 
\a 报警 (bell) 符 ('\u0007') 
\e 转义符 ('\u001B') 
\cx 对应于 x 的控制符 

字符类 
[abc] a、b 或 c（简单类） 
[^abc] 任何字符，除了 a、b 或 c（否定） 
[a-zA-Z] a 到 z 或 A 到 Z，两头的字母包括在内（范围） 
[a-d[m-p]] a 到 d 或 m 到 p：[a-dm-p]（并集） 
[a-z&&[def]] d、e 或 f（交集） 
[a-z&&[^bc]] a 到 z，除了 b 和 c：[ad-z]（减去） 
[a-z&&[^m-p]] a 到 z，而非 m 到 p：[a-lq-z]（减去） 

预定义字符类 
. 任何字符（与行结束符可能匹配也可能不匹配）一般换行符除外；
\d 数字：[0-9] 
\D 非数字： [^0-9] 
\s 空白字符：[ \t\n\x0B\f\r] 
\S 非空白字符：[^\s] 
\w 单词字符：[a-zA-Z_0-9] 
\W 非单词字符：[^\w] 

边界匹配器
^ 行的开头 
$ 行的结尾 
\b 单词边界 
\B 非单词边界 
\A 输入的开头 
\G 上一个匹配的结尾 
\Z 输入的结尾，仅用于最后的结束符（如果有的话） 
\z 输入的结尾 

* 零次或者多次匹配表达式{0,}； + 一次或者多次{1,}；？零次或者一次； 
[] 开始和结尾，括号表达式，[1-4] 与1、2、3、4匹配；
{} 开始和结尾，限定符，a{2,3}与aa与aaa匹配；
{n} 正好匹配n次
{n,} 至少匹配n次
() 开始结尾，子表达式  A(\d)与A0-A9匹配，子表达式备用
| 指示在两者或者多者之间选择； 
/ 开始或结尾 第二个/ 后指定搜索； 
\ 将下一字符标为特殊字符，例如文本反向引用或八进制转义等；  

【Pattern 类】的对象表示通过编译的正则表达式，该对象可以喝任意字符串进行模式的匹配，该对象的构造方法私有，
需要调用public static Pattern compile(String regex)  会将regex编译成Pattern对象并返回；
static Pattern compile(String regex, int flags)  flag表示指定的匹配标志，一般用标识常量表示，例如
Pattern.CASE_INSENSITIVE表示不区分大小写的匹配，Pattern.COMMENTS 表示启用允许空白和注释，多个标识符号
直接使用"+"连接在一起即可；
int flags() 返回此模式的匹配标志
Matcher matcher(CharSequence input) 创建匹配给定输入此模式的匹配器；CharSequence是String等的上层接口；
static boolean matches(String regex, CharSequence input) 编译正则表达式，并尝试将给定输入与其匹配；
String pattern() 返回在其中编译过此模式的正则表达式；
static String quote(String s)  返回指定 String 的字面值模式 String。 
【Matcher类】该对象表示将要进行模式匹配的字符串或者字符序列，一般通过Pattern的matcher()方法获得对象；
boolean matches() 尝试将整个区域与模式匹配
Pattern pattern() 返回由此匹配器解释的模式。
【String类】里的正则表达式（完全匹配）
public boolean(String regex) 匹配返回true，否则返回false，refex无效则抛异常；
String replaceAll(String regex,String replacement)匹配正则表达式regex，全部替换为replacement；
String replaceFirst(String regex,String replacement) 只替换第一个；
String[] split(String regex) 根据给定的正则表达式拆分；
String[] split(String regex,int limit) limit用来限制拆分份数；正数拆分为limit份，负数尽可能多拆分；0尽可能多拆分，抛弃结尾空字符串；

用正则表达式判断是否符合某个格式，例如：判断一个号码是不是手机号码
String phone = 12142342....
String patternStr = "^1[3|4|5|8]\\d{9}$";   //String的匹配正则表达式
Pattern pattern = Pattrn.compile(patternStr);	//获得通过编译的正则表达式
Matcher matcher = pattern.matcher(phone);	//获得进行模式匹配的字符串
matcher.matches();		//返回是否匹配结果


【】时间处理：
Java.util.Date 表示特定瞬间，精确到毫秒；
	构造方法 Date() Date(long data)以1970.1.1位计算机原点
java.text.DateFormat 抽象类	
实现类是SimpleDateFormat 
构造方法 SimpleDateFormat("时间格式")
方法 String format(Date date)
	Date parse(String str)
G Gra标识符；
y 年，M 月，w 周（年记），W 周（月记），D天数（年记），d天数（月记），
F 星期（月），E星期（星期几），a 上下午 ，H小时数（0-23） ，k小时数（1-24），K小时数（0-11）
h 小时数（1-12）， m 小时分钟数 ，s 分钟中的秒数 ，S 毫秒 ，z 时区 GMT ；Z 时区 0800
	
=====CoreJava-设计模式==================================================================
// http://blog.csdn.net/jason0539/article/details/44956775;
设计模式分为三大类：
创建型模式，共五种：工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式。
结构型模式，共七种：适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式。
行为型模式，共十一种：策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式。
其实还有两类：并发型模式和线程池模式。

设计模式的六大原则：
总原则－开闭原则
对扩展开放，对修改封闭。在程序需要进行拓展的时候，不能去修改原有的代码，而是要扩展原有代码，实现一个热插拔的效果。
所以一句话概括就是：为了使程序的扩展性好，易于维护和升级。
想要达到这样的效果，我们需要使用接口和抽象类等，后面的具体设计中我们会提到这点。

1、单一职责原则
不要存在多于一个导致类变更的原因，也就是说每个类应该实现单一的职责，否则就应该把类拆分。

2、里氏替换原则（Liskov Substitution Principle）
任何基类可以出现的地方，子类一定可以出现。里氏替换原则是继承复用的基石，只有当衍生类可以替换基类，软件单位的功能不受到影响时，基类才能真正被复用，
而衍生类也能够在基类的基础上增加新的行为。
里氏代换原则是对“开-闭”原则的补充。实现“开闭”原则的关键步骤就是抽象化。而基类与子类的继承关系就是抽象化的具体实现，所以
里氏代换原则是对实现抽象化的具体步骤的规范。里氏替换原则中，子类对父类的方法尽量不要重写和重载。
因为父类代表了定义好的结构，通过这个规范的接口与外界交互，子类不应该随便破坏它。

3、依赖倒转原则（Dependence Inversion Principle）
面向接口编程，依赖于抽象而不依赖于具体。写代码时用到具体类时，不与具体类交互，而与具体类的上层接口交互。

4、接口隔离原则（Interface Segregation Principle）
每个接口中不存在子类用不到却必须实现的方法，如果不然，就要将接口拆分。使用多个隔离的接口，比使用单个接口（多个接口方法集合到一个的接口）要好。

5、迪米特法则（最少知道原则）（Demeter Principle）
一个类对自己依赖的类知道的越少越好。无论被依赖的类多么复杂，都应该将逻辑封装在方法的内部，通过public方法提供给外部。这样当被依赖的类变化时，才能最小的影响该类。
最少知道原则的另一个表达方式是：只与直接的朋友通信。类之间只要有耦合关系，就叫朋友关系。
耦合分为依赖、关联、聚合、组合等。我们称出现为成员变量、方法参数、方法返回值中的类为直接朋友。
局部变量、临时变量则不是直接的朋友。我们要求陌生的类不要作为局部变量出现在类中。

6、合成复用原则（Composite Reuse Principle）
尽量首先使用合成/聚合的方式，而不是使用继承。

创建型模式：工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式
结构型模式：适配器模式、装饰者模式、代理模式、外观模式、桥接模式、组合模式、享元模式
行为型模式：策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式
还有两类：并发型模式和线程池模式。

单例模式

一、懒汉式单例 在第一次调用的时候实例化自己 
public class Singleton {  
    private Singleton() {}  
    private static volatile Singleton single=null;  
    //静态工厂方法   
    public static Singleton getInstance() {  
         if (single == null) {    
             single = new Singleton();  
         }    
        return single;  
    }  
} 
1、在getInstance方法上加同步
public static synchronized Singleton getInstance() {  
	if (single == null) {    
		single = new Singleton();  
	}    
	return single;  
}
2、双重检查锁定
public static Singleton getInstance() {  
	if (singleton == null) {    
		synchronized (Singleton.class) {    
			if (singleton == null) {    
				singleton = new Singleton();   
			}    
		}    
	}    
	return singleton;   
} 
3、静态内部类
public class Singleton {    
    private static class LazyHolder {    
       private static final Singleton INSTANCE = new Singleton();    
    }    
    private Singleton (){} 
	
    public static final Singleton getInstance() {    
       return LazyHolder.INSTANCE;    
    }    
}  
二、饿汉式单例 饿汉式单例类.在类初始化时，已经自行实例化   
public class Singleton {  
    private Singleton() {}  
    private static final Singleton SINGLE = new Singleton();  
    //静态工厂方法   
    public static Singleton getInstance() {  
        return SINGLE;  
    }  
}  

===CoreJava-Java关键字=================================================================
访问控制修饰符：
	私有的 private，默认的 (default)，受保护的 protected。公共的 public
类、方法和变量修饰符：
	声明抽象 abstract，类 class，继承扩充 extends，不可改变的终极 final
	实现 implements，接口 interface，本地 native，创建新 new，静态 static
	精准严格 strictfp，同步线程 synchronized，短暂不参与序列化transient
	易失防止被优化 volatile，可序列化标记接口 Serializable
程序控制语句：
	跳出循环 break，继续 continue，返回 return，运行 do
	循环 while，如果 if，反之 else，循环 for，是不是实例 instanceof
	开关 switch，返回开关里的结果 case，默认 default
错误异常处理：
	处理异常 catch，有没有异常都执行 finally，抛出一个异常对象 throw
	声明一个异常可能被抛出 throws，捕获异常 try
包相关：
	引入 import，包 package
基本类型：
	布尔型 boolean，字节型 byte，字符型 char，双精度 double
	浮点 float，整型 int，长整型 long，短整型 short
变量引用
	父类 super，本类 this，无返回值 void
	
	
