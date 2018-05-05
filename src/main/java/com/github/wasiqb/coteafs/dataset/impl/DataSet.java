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

import com.github.wasiqb.coteafs.dataset.IDataSet;
import com.github.wasiqb.coteafs.dataset.IDataTable;

/**
 * @author Wasiq Bhamla
 * @since Apr 22, 2018
 */
public class DataSet implements IDataSet {
	private boolean					headerPrinted	= false;
	private int						tableIndex;
	private final List <IDataTable>	tables;

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 22, 2018
	 */
	public DataSet () {
		this.tables = new ArrayList <> ();
		this.tableIndex = -1;
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataAppendable#add(java.lang.Object)
	 */
	@Override
	public IDataSet add (final IDataTable table) {
		this.tables.add (table);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataIterable#count()
	 */
	@Override
	public int count () {
		return this.tables.size ();
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataIterable#current()
	 */
	@Override
	public IDataTable current () {
		if (this.tableIndex < 0) return first ();
		return table (this.tableIndex);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataIterable#first()
	 */
	@Override
	public IDataTable first () {
		this.tableIndex = 0;
		return table (this.tableIndex);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataIterable#last()
	 */
	@Override
	public IDataTable last () {
		this.tableIndex = count () - 1;
		return table (this.tableIndex);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataIterable#next()
	 */
	@Override
	public IDataTable next () {
		return table (++this.tableIndex);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataIterable#previous()
	 */
	@Override
	public IDataTable previous () {
		return table (--this.tableIndex);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataSet#table(int)
	 */
	@Override
	public IDataTable table (final int index) {
		this.tableIndex = index;
		if (this.tableIndex < 0)
			return first ();
		else if (this.tableIndex == count ()) return last ();
		return this.tables.get (this.tableIndex);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataSet#table(java.lang.String)
	 */
	@Override
	public IDataTable table (final String name) {
		for (final IDataTable table : this.tables) {
			if (table.name ()
				.equals (name)) return table;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataSet#tables()
	 */
	@Override
	public List <IDataTable> tables () {
		return this.tables;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString () {
		final StringBuilder sb = new StringBuilder ();
		tables ().forEach (t -> {
			this.headerPrinted = false;
			sb.append ("Table: " + t.name () + "\n");
			t.rows ()
				.forEach (r -> {
					if (!this.headerPrinted) {
						r.columns ()
							.forEach (c -> sb.append ("| " + c.variable ()
								.name () + " "));
						this.headerPrinted = true;
					}
					sb.append ("|\n");
					r.columns ()
						.forEach (c -> sb.append ("| " + c.value () + " "));
				});
			sb.append ("|\n\n");
		});
		return sb.toString ();
	}
}