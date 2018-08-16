package proxy;
import javax.servlet.http.HttpServletRequest;
import lombok.Data;
@Data
public class Proxy implements Capable{
	private Pagination pagination;
	private HttpServletRequest request;
	
	@Override
	public void carryOut(Object o) {
		this.pagination = new Pagination();
		pagination.carryOut(o);
	}
}
