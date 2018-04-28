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

/**
 * @author Wasiq Bhamla
 * @param <T>
 * @since Apr 28, 2018
 */
public interface IDataIterable <T> {
	/**
	 * @author Wasiq Bhamla
	 * @since Apr 22, 2018
	 * @return count
	 */
	int count ();

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 * @return current table.
	 */
	T current ();

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 22, 2018
	 * @return first table
	 */
	T first ();

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 22, 2018
	 * @return last table
	 */
	T last ();

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 22, 2018
	 * @return next table
	 */
	T next ();

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 22, 2018
	 * @return previous table
	 */
	T previous ();
}