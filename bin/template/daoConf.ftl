<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE sqlMapConfig PUBLIC "-//iBATIS.com//DTD SQL Map Config 2.0//EN"
        "http://ibatis.apache.org/dtd/sql-map-config-2.dtd">

<sqlMapConfig>
    <settings useStatementNamespaces="false" cacheModelsEnabled="false"
              lazyLoadingEnabled="false" enhancementEnabled="false"
              maxRequests="3000" maxSessions="3000" maxTransactions="3000"/>
    <sqlMap resource="ibatis/${daoConf}" />
</sqlMapConfig>
