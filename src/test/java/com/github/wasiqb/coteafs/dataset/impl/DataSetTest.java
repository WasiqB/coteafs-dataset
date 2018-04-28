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

import static com.google.common.truth.Truth.assertThat;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.wasiqb.coteafs.dataset.IDataColumn;
import com.github.wasiqb.coteafs.dataset.IDataRow;
import com.github.wasiqb.coteafs.dataset.IDataSet;
import com.github.wasiqb.coteafs.dataset.IDataTable;

/**
 * @author Wasiq Bhamla
 * @since Apr 28, 2018
 */
public class DataSetTest {
	private IDataSet dataSet;

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@BeforeClass
	public void setup () {
		this.dataSet = new DataSet ();
		final IDataTable table = new DataTable ();
		table.name ("Test");
		final Object [] [] data = new Object [] [] { { "Wasiq", 30 }, { "Chintan", 31 }, { "Alex", 29 } };
		final Object [] [] columns = new Object [] [] { { 1, "Name" }, { 2, "Age" } };

		for (final Object [] row : data) {
			final IDataRow r = new DataRow ();
			for (final Object [] column : columns) {
				final int index = Integer.parseInt (column [0].toString ());
				final IDataColumn col = new DataColumn (index, column [1].toString ());
				col.value (row [index - 1]);
				r.add (col);
			}
			table.add (r);
		}
		this.dataSet.add (table);
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testDataSetCount () {
		assertThat (this.dataSet.count ()).isEqualTo (1);
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testDataSetNext () {
		assertThat (this.dataSet.next ()
			.name ()).isEqualTo ("Test");
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testDataSetTables () {
		assertThat (this.dataSet.tables ()
			.size ()).isEqualTo (1);
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testDataSetTableWithIndex () {
		assertThat (this.dataSet.table (0)
			.name ()).isEqualTo ("Test");
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testDataSetTableWithName () {
		assertThat (this.dataSet.table ("Test")
			.name ()).isEqualTo ("Test");
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testDataSetWhereNameNotExists () {
		assertThat (this.dataSet.table ("Test1")).isNull ();
	}
}