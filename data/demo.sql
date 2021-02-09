USE `demo`;

SELECT 
    u.id userid, u.username, 
    r.rolename, 
    p.permissionname
FROM 
    users as u,
    roles as r,
    permissions as p,
    user_role as ur,
    role_permission as rp
WHERE u.id=2 
    AND u.id=ur.uid 
    AND ur.rid=r.id
    AND rp.rid=ur.rid 
    AND p.id=rp.pid;