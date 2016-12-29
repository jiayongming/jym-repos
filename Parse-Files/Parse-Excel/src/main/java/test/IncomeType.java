package test;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * 收益明细类型
 * value 为app传入参数
 * realValue 为传给代销的真正参数
 * @author 贾永明
 */
public enum IncomeType {
	/**
	 * 单类型的收益类型
	 */
	A0("A0","A0","基金分红"),
	A1("A1","A1","爽活宝收益"),
	A2("A2","A2","快提扣减收益"),
	A3("A3","A3","新人宝收益")
	;
	public final static List<String> newValue = Lists.newArrayListWithCapacity(8);
	static {
		newValue.add("test") ;
		newValue.add(A0.realValue) ;
	}
	
	private IncomeType(String value,String realValue,String describe) {
        this.value = value ;
        this.realValue = realValue ;
        this.describe = describe ;
    }
	private String value ;
	private String describe ;
	private String realValue ;
	public String value() {
		return value;
	}
	public String describe() {
		return describe;
	}
	public String realValue() {
		return realValue;
	}
}
