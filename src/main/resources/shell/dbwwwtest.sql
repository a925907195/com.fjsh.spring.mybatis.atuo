
-- ----------------------------
-- Table structure for t_user_area
-- ----------------------------
DROP TABLE IF EXISTS `t_user_area`;
CREATE TABLE `t_user_area` (
  `id` bigint(20) NOT NULL,
  `name` varchar(30) DEFAULT '' COMMENT '用户名称',
  `sex` varchar(10) DEFAULT '' COMMENT '性别0：男  1：女',
  `age` varchar(30) DEFAULT '' COMMENT '年龄，出生年份',
  `phone` varchar(30) DEFAULT '' COMMENT '手机号',
  `areacompid` bigint(20) DEFAULT NULL COMMENT '城市分公司id',
  `status` tinyint(1) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  `updatetime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='大区允许登录的用户信息';

-- ----------------------------
-- Table structure for t_user_extrainfo
-- ----------------------------
DROP TABLE IF EXISTS `t_user_extrainfo`;
CREATE TABLE `t_user_extrainfo` (
  `id` bigint(20) NOT NULL,
  `name` varchar(30) DEFAULT '' COMMENT '用户名称',
  `sex` varchar(10) DEFAULT '' COMMENT '性别',
  `birth` varchar(30) DEFAULT '' COMMENT '出生年份',
  `phone` varchar(30) DEFAULT '' COMMENT '手机号',
  `status` tinyint(1) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  `updatetime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='额外的用户信息';
