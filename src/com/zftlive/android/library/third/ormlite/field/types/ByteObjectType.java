package com.zftlive.android.library.third.ormlite.field.types;

import java.sql.SQLException;

import com.zftlive.android.library.third.ormlite.field.FieldType;
import com.zftlive.android.library.third.ormlite.field.SqlType;
import com.zftlive.android.library.third.ormlite.support.DatabaseResults;

/**
 * Type that persists a Byte object.
 * 
 * @author graywatson
 */
public class ByteObjectType extends BaseDataType {

	private static final ByteObjectType singleTon = new ByteObjectType();

	public static ByteObjectType getSingleton() {
		return singleTon;
	}

	private ByteObjectType() {
		super(SqlType.BYTE, new Class<?>[] { Byte.class });
	}

	protected ByteObjectType(SqlType sqlType, Class<?>[] classes) {
		super(sqlType, classes);
	}

	@Override
	public Object parseDefaultString(FieldType fieldType, String defaultStr) {
		return Byte.parseByte(defaultStr);
	}

	@Override
	public Object resultToSqlArg(FieldType fieldType, DatabaseResults results, int columnPos) throws SQLException {
		return (Byte) results.getByte(columnPos);
	}

	@Override
	public boolean isEscapedValue() {
		return false;
	}
}
