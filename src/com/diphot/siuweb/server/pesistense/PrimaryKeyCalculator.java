package com.diphot.siuweb.server.pesistense;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class PrimaryKeyCalculator {

	/**
	 * Get the ID supplied, or get it from the encoded key string if the ID is
	 * <code>null</code>.
	 * <br/>
	 * This method is necessary since JDO version 3.0.1 introduces a long delay
	 * between entity first persistence and ID availability using the DataNucleus
	 * GAE primary key ID plug-in.
	 * @param id
	 *   The persistent entity ID.
	 *   This may be <code>null</code> if the entity has been persisted for the
	 *   first time but its generation is delayed (a big hello to JDO version
	 *   3.0.1).
	 * @param encodedKey
	 *   The persistent entity encoded key string.
	 *   This should be not <code>null</code> if the entity has been persisted.
	 * @return
	 *   <ul>
	 *     <li>
	 *       If the persistent entity ID supplied is not <code>null</code>
	 *       then return it
	 *     </li>
	 *     <li>
	 *       else if the encoded key string is not <code>null</code> then extract
	 *       the ID and return it
	 *     </li>
	 *     <li>
	 *       else return <code>null</code>.
	 *     </li>
	 *   </ul>
	 */
	public static Long getIDFromEKSIfIDIsNull(Long id, String encodedKey) {
		Long result = null;
		if (id != null){
			result = id;
		} else if (encodedKey != null)	{
			Key key = KeyFactory.stringToKey(encodedKey);
			if (key != null) {
				long loIDFromEKS = key.getId();
				result = Long.valueOf(loIDFromEKS);
			}
		}
		return result;
	}
}
