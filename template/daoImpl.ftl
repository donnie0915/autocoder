package ${package} ;

import org.springframework.stereotype.Repository;

import ${dao};

import ${base_dao_impl};
import ${dao_statement_name};
import ${default_dao_statement_name};
/**
 * 
 * @author ${author}
 * @version ${version}
 *
 */
@Repository("<@lowerFirstChar>${className}</@lowerFirstChar>Dao")
public class ${className}DaoImpl<${className}> extends BaseDaoImpl<${className}> implements  ${className}Dao<${className}>{
	@Override
	public DaoStatementName getDaoStatementName() {
		return  new DefaultDaoStatementName(){
			public String getDomainName(){
				return "${className}";
			}
		};
	}
} 
