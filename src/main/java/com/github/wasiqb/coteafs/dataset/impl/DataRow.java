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
import java.util.Optional;

import com.github.wasiqb.coteafs.dataset.IDataColumn;
import com.github.wasiqb.coteafs.dataset.IDataRow;

/**
 * @author Wasiq Bhamla
 * @since Apr 22, 2018
 */
public class DataRow implements IDataRow {
	private int							colIndex;
	private final List <IDataColumn>	columns;

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 22, 2018
	 */
	public DataRow () {
		this.columns = new ArrayList <> ();
		this.colIndex = -1;
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataAppendable#add(java.lang.Object)
	 */
	@Override
	public IDataRow add (final IDataColumn column) {
		this.columns.add (column);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataRow#column(int)
	 */
	@Override
	public IDataColumn column (final int index) {
		for (final IDataColumn column : this.columns) {
			if (column.variable ()
				.index () == index) {
				this.colIndex = index;
				return column;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataRow#column(java.lang.String)
	 */
	@Override
	public IDataColumn column (final String name) {
		final Optional <IDataColumn> result = this.columns.stream ()
			.filter (c -> c.variable ()
				.name ()
				.equals (name))
			.findFirst ();
		if (result.isPresent ()) {
			final IDataColumn col = result.get ();
			this.colIndex = col.variable ()
				.index ();
			return col;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataRow#columns()
	 */
	@Override
	public List <IDataColumn> columns () {
		return this.columns;
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataIterable#count()
	 */
	@Override
	public int count () {
		return this.columns.size ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataIterable#current()
	 */
	@Override
	public IDataColumn current () {
		if (this.colIndex < 0) return first ();
		return column (this.colIndex);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataIterable#first()
	 */
	@Override
	public IDataColumn first () {
		this.colIndex = 0;
		return column (this.colIndex);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataIterable#last()
	 */
	@Override
	public IDataColumn last () {
		this.colIndex = count () - 1;
		return column (this.colIndex);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataIterable#next()
	 */
	@Override
	public IDataColumn next () {
		this.colIndex++;
		if (this.colIndex == count ()) return last ();
		return column (this.colIndex);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataIterable#previous()
	 */
	@Override
	public IDataColumn previous () {
		this.colIndex--;
		if (this.colIndex < 0) return first ();
		return column (this.colIndex);
	}
}