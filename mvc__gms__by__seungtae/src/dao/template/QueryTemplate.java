package dao.template;
import java.sql.PreparedStatement;
import java.util.*;

import dao.factory.DataBaseFactory;
import dao.template.values.DBConstant;
import dao.template.values.Vendor;
import lombok.Data;
@Data
public abstract class QueryTemplate {
	protected boolean f;
	protected int n;
	protected String s;
	protected Object o;
	protected List<Object> l;
	protected Map<String,Object> m;
	protected PreparedStatement pstmt;
	public abstract void initialize();
	public abstract void startPlay();
	public abstract void endPlay();
	public void pStmtInit() {
    	try {
			this.pstmt = DataBaseFactory.createDataBase2(m)
					.getConnection()
					.prepareStatement((String)m.get("sql"));
		} catch (Exception e) {
			e.printStackTrace();
		};
    }
    public void play(Map<?, ?> param){
    	init();
	    this.m.put("vendor", Vendor.ORACLE);
	    this.m.put("dbusername", DBConstant.USERNAME);
	    this.m.put("dbpassword", DBConstant.PASSWORD);
	    Iterator<?> keys = param.keySet().iterator();
	    while(keys.hasNext()) {
	    	String key = (String) keys.next();
	    	this.m.put(key, param.get(key));
	    }
        initialize();
        pStmtInit();
        startPlay();
        endPlay();
   }
    public void play() {
    	init();
		this.m.put("vendor",Vendor.ORACLE);
		this.m.put("dbusername", DBConstant.USERNAME);
		this.m.put("dbpassword", DBConstant.PASSWORD);
		initialize();
		pStmtInit();
		startPlay();
		endPlay();
	}
    public void init(){
    	this.f = false;
    	this.n = 0;
      	this.s = "";
    	this.o = new Object();
    	this.l = new ArrayList<>();
    	this.m = new HashMap<>();
    }
}
