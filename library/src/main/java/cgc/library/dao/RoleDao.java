package cgc.library.dao;

import cgc.library.model.Role;

/**
 * Role Data Access Object (DAO) interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface RoleDao extends PaginatedDao<Role, Long> {
    /**
     * Gets role information based on role name
     * @param rolename the role name
     * @return populated role object
     */
    Role getRoleByName(String rolename);

    /**
     * Removes a role from the database by name
     * @param rolename the role's rolename
     */
    void removeRole(String rolename);
}
