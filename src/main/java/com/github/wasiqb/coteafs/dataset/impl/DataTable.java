/**
 * Copyright 2016, wizonsoft, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.wasiqb.coteafs.dataset.impl;

import java.util.ArrayList;
import java.util.List;

import com.github.wasiqb.coteafs.dataset.IDataRow;
import com.github.wasiqb.coteafs.dataset.IDataTable;

/**
 * @author Wasiq Bhamla
 * @since Apr 22, 2018
 */
public class DataTable implements IDataTable {
	private String					name;
	private int						rowIndex;
	private final List <IDataRow>	rows;

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 22, 2018
	 */
	public DataTable () {
		this.rows = new ArrayList <> ();
		this.rowIndex = -1;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.github.wasiqb.coteafs.dataset.IDataTable#add(com.github.wasiqb.coteafs.dataset.IDataRow)
	 */
	@Override
	public IDataTable add (final IDataRow row) {
		this.rows.add (row);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataTable#count()
	 */
	@Override
	public int count () {
		return this.rows.size ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataTable#current()
	 */
	@Override
	public IDataRow current () {
		return row (this.rowIndex);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataTable#first()
	 */
	@Override
	public IDataRow first () {
		return row (0);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataTable#last()
	 */
	@Override
	public IDataRow last () {
		return row (count () - 1);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataTable#name()
	 */
	@Override
	public String name () {
		return this.name;
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataTable#name(java.lang.String)
	 */
	@Override
	public IDataTable name (final String tableName) {
		this.name = tableName;
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataTable#next()
	 */
	@Override
	public IDataRow next () {
		return row (++this.rowIndex);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataTable#previous()
	 */
	@Override
	public IDataRow previous () {
		return row (--this.rowIndex);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataTable#row(int)
	 */
	@Override
	public IDataRow row (final int index) {
		this.rowIndex = index;
		if (this.rowIndex < 0)
			return first ();
		else if (this.rowIndex == count ()) return last ();
		return this.rows.get (this.rowIndex);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataTable#rows()
	 */
	@Override
	public List <IDataRow> rows () {
		return this.rows;
	}
}