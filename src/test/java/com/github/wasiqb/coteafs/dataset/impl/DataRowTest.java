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

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.wasiqb.coteafs.dataset.IDataColumn;
import com.github.wasiqb.coteafs.dataset.IDataRow;

/**
 * @author Wasiq Bhamla
 * @since Apr 28, 2018
 */
public class DataRowTest {
	private IDataColumn			age;
	private List <IDataColumn>	cols;
	private IDataColumn			name;
	private IDataRow			row;

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@BeforeClass
	public void setup () {
		this.name = new DataColumn (1, "Name");
		this.name.value ("wizonsoft");
		this.age = new DataColumn (2, "Age");
		this.age.value (10);
		this.cols = new ArrayList <> ();
		this.cols.add (this.name);
		this.cols.add (this.age);

		this.row = new DataRow ();
		this.row.add (this.name)
			.add (this.age);
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testColumns () {
		int index = 0;
		for (final IDataColumn column : this.row.columns ()) {
			assertThat (column.value ()
				.toString ()).isEqualTo (this.cols.get (index++)
					.value ()
					.toString ());
		}
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testColumnWithIndex () {
		assertThat (this.row.column (1)
			.value ()
			.toString ()).isEqualTo (this.name.value ()
				.toString ());
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testColumnWithIndexNotExists () {
		assertThat (this.row.column (3)).isNull ();
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testColumnWithName () {
		assertThat (this.row.column ("Age")
			.value ()
			.toString ()).isEqualTo (this.age.value ()
				.toString ());
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testColumnWithNameNotExists () {
		assertThat (this.row.column ("Age1")).isNull ();
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testCount () {
		assertThat (this.row.count ()).isEqualTo (2);
	}
}