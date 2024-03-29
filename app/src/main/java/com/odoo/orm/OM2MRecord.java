/*
 * Odoo, Open Source Management Solution
 * Copyright (C) 2012-today Odoo SA (<http:www.odoo.com>)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http:www.gnu.org/licenses/>
 * 
 */
package com.odoo.orm;

import java.util.List;

public class OM2MRecord {
	OColumn mCol = null;
	int mId = 0;
	OModel mDatabase = null;

	public OM2MRecord(OModel model, OColumn col, int id) {
		mDatabase = model;
		mCol = col;
		mId = id;
	}

	public List<ODataRow> browseEach() {
		OModel rel = mDatabase.createInstance(mCol.getType());
		return mDatabase.selectM2MRecords(mDatabase, rel, mId);
	}

	public ODataRow browseAt(int index) {
		List<ODataRow> list = browseEach();
		if (list.size() == 0) {
			return null;
		}
		return list.get(index);
	}

}
