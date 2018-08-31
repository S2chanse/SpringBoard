package com.spring.pds.service.typehandler;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.jdbc.support.nativejdbc.CommonsDbcpNativeJdbcExtractor;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

public class ListMapTypeHandler implements TypeHandler<Object>{

	@Override
	public void setParameter(PreparedStatement ps, int i
			, Object parameter, JdbcType jdbcType) throws SQLException {
		List<String>list=(List<String>)parameter;
		String[] strings=new String[list.size()];
		for(int j=0;j<list.size();j++) {
			strings[j]=list.get(j);
		}
		//db연결
		CommonsDbcpNativeJdbcExtractor extractor=new CommonsDbcpNativeJdbcExtractor();
		Connection conn=extractor.getNativeConnection(ps.getConnection());
		ArrayDescriptor desc=ArrayDescriptor.createDescriptor("FILE_ARRAY",conn);
		parameter=new ARRAY(desc,conn,strings);
		
		ps.setArray(i,(oracle.sql.ARRAY)parameter);
	}

	@Override
	public Object getResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
		if(cs.wasNull()) {
			return null;
		}else {
			return cs.getString(columnIndex);
		}
	}

}
