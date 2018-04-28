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
import com.github.wasiqb.coteafs.dataset.IDataTable;

/**
 * @author Wasiq Bhamla
 * @since Apr 28, 2018
 */
public class DataTableTest {
	private IDataTable table;

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@BeforeClass
	public void setup () {
		this.table = new DataTable ();
		this.table.name ("Test");
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
			this.table.add (r);
		}
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testDataTableCount () {
		assertThat (this.table.count ()).isEqualTo (3);
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testDataTableCurrent () {
		this.table.first ();
		final IDataRow current = this.table.current ();
		assertThat (current.column ("Name")
			.value ()
			.toString ()).isEqualTo ("Wasiq");
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testDataTableFirst () {
		final IDataRow first = this.table.first ();
		assertThat (first.column ("Name")
			.value ()
			.toString ()).isEqualTo ("Wasiq");
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testDataTableLast () {
		final IDataRow last = this.table.last ();
		assertThat (last.column ("Name")
			.value ()
			.toString ()).isEqualTo ("Alex");
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testDataTableName () {
		assertThat (this.table.name ()).isEqualTo ("Test");
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testDataTableNext () {
		this.table.first ();
		final IDataRow next = this.table.next ();
		assertThat (next.column ("Name")
			.value ()
			.toString ()).isEqualTo ("Chintan");
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testDataTablePrevious () {
		final IDataRow first = this.table.previous ();
		assertThat (first.column ("Name")
			.value ()
			.toString ()).isEqualTo ("Wasiq");
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testDataTableRow () {
		final IDataRow row = this.table.row (1);
		assertThat (row.column ("Name")
			.value ()
			.toString ()).isEqualTo ("Chintan");
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testDataTableRows () {
		final String [] expected = { "Wasiq", "Chintan", "Alex" };
		for (int index = 0; index < this.table.count (); index++) {
			final IDataRow row = this.table.rows ()
				.get (index);
			assertThat (row.column ("Name")
				.value ()
				.toString ()).isEqualTo (expected [index]);
		}
	}
}