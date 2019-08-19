package kr.or.ddit.ibatis.config;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {
	
	public static SqlMapClient getSqlMapClient() {
		return client;
	}
	
	private static SqlMapClient client;
	
	static {
		try {
			// 문자 인코딩 캐릭터셋 설정
			Charset charset = Charset.forName("utf-8");
			Resources.setCharset(charset);
			
			// xml문서 읽어오기
			Reader rd = Resources.getResourceAsReader("kr/or/ddit/ibatis/config/sqlMapConfig.xml");
			
			// 위에서 읽어온 Reader객체를 이용하여 실제 작업을 수행할 SqlMapClient객체를 생성한다.
			client = SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
}
