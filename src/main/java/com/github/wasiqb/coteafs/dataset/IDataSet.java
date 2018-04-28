/**
 * Copyright (c) 2017-2020, Wasiq Bhamla.
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
package com.github.wasiqb.coteafs.dataset;

import java.util.List;

/**
 * @author Wasiq Bhamla
 * @since Apr 22, 2018
 */
public interface IDataSet extends IDataIterable <IDataTable>, IDataAppendable <IDataSet, IDataTable> {
	/**
	 * @author Wasiq Bhamla
	 * @since Apr 22, 2018
	 * @param index
	 * @return table
	 */
	IDataTable table (int index);

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 22, 2018
	 * @param name
	 * @return table
	 */
	IDataTable table (String name);

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 22, 2018
	 * @return tables
	 */
	List <IDataTable> tables ();
}