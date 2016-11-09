package test;

import static org.apache.commons.lang3.builder.ToStringStyle.MULTI_LINE_STYLE;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author 贾永明 优选理财列表参数
 */
public final class HonorParam implements Serializable {

	private static final long serialVersionUID = -4828881541246781640L;

	private String footName = getFootName() ;
	private String desDay;
	private String moneyLimit;
	private String fpInfo;
	private Integer fpType;
	private String fp;
	private Integer currentPage;
	private Integer pageSize;
	private String webId = getWebId();

	public String getFootName() {
		return footName;
	}

	public void setFootName(String footName) {
		this.footName = footName;
	}

	public String getDesDay() {
		return desDay;
	}

	public void setDesDay(String desDay) {
		this.desDay = desDay;
	}

	public String getMoneyLimit() {
		return moneyLimit;
	}

	public void setMoneyLimit(String moneyLimit) {
		this.moneyLimit = moneyLimit;
	}

	public String getFpInfo() {
		return fpInfo;
	}

	public void setFpInfo(String fpInfo) {
		this.fpInfo = fpInfo;
	}

	public Integer getFpType() {
		return fpType;
	}

	public void setFpType(Integer fpType) {
		this.fpType = fpType;
	}

	public String getFp() {
		return fp;
	}

	public void setFp(String fp) {
		this.fp = fp;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getWebId() {
		return "LLLLLLLL";
	}

	public void setWebId(String webId) {
		this.webId = webId;
	}

	@Override
	public String toString() {
		return "HonorParam [footName=" + footName + ", desDay=" + desDay + ", moneyLimit=" + moneyLimit + ", fpInfo=" + fpInfo + ", fpType=" + fpType + ", fp=" + fp + ", currentPage=" + currentPage + ", pageSize=" + pageSize + ", webId=" + webId + "]";
	}

	public static void main(String[] args) {
		HonorParam honorParam = new HonorParam();
		System.out.println(honorParam);
	}

}
