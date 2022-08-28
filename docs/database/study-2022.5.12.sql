-- --------------------------------------------------------
-- 主机:                           cdb-qmt11q3w.bj.tencentcdb.com
-- 服务器版本:                        5.7.18-20170830-log - 20170531
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- 导出  表 study.so_all_content 结构
CREATE TABLE IF NOT EXISTS `so_all_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `title` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '标题',
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '内容',
  `author` char(20) COLLATE utf8_bin DEFAULT NULL COMMENT '作者',
  `readTimes` int(11) DEFAULT NULL COMMENT '阅读/观看次数',
  `discussTimes` int(11) DEFAULT NULL COMMENT '评论次数',
  `type` char(10) COLLATE utf8_bin DEFAULT NULL COMMENT '类型',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  `deletedTime` datetime DEFAULT NULL COMMENT '删除时间',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `extrai` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '一级分类',
  `extraii` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `extraiii` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '备用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  study.so_all_content 的数据：~24 rows (大约)
/*!40000 ALTER TABLE `so_all_content` DISABLE KEYS */;
INSERT INTO `so_all_content` (`id`, `title`, `content`, `author`, `readTimes`, `discussTimes`, `type`, `createdTime`, `updateTime`, `deletedTime`, `status`, `extrai`, `extraii`, `extraiii`) VALUES
	(1, 'edit1.关于数学学习的有效方法讨论测试', '11针对考研的数学科目，根据各学科、专业对硕士研究生入学所应具备的数学知识和能力的不同要求，硕士研究生入学统考数学试卷分为3种：其中针对工科类的为数学一、数学二；针对经济学和管理学类的为数学三（2009年之前管理类为数学三，经济类为数学四，2009年之后大纲将数学三数学四合并）。具体不同专业所使用的试卷种类有具体规定。', 'jingenqiang', 12, 5, 'article', '2020-11-13 22:10:24', '2020-11-13 22:10:32', '2020-11-13 22:10:36', 1, 'sx', NULL, NULL),
	(2, 'e2. 针对考研的数学科目，根据各学科、专业对硕士研究生入学所应具备的数学知识和能力的不同要求', '22针对考研的数学科目，根据各学科、专业对硕士研究生入学所应具备的数学知识和能力的不同要求，硕士研究生入学统考数学试卷分为3种：其中针对工科类的为数学一、数学二；针对经济学和管理学类的为数学三（2009年之前管理类为数学三，经济类为数学四，2009年之后大纲将数学三数学四合并）。具体不同专业所使用的试卷种类有具体规定。', 'jingenqiang', 12, 5, 'article', '2020-11-13 22:10:24', '2020-11-13 22:10:32', '2020-11-13 22:10:36', 1, 'sx', NULL, NULL),
	(3, '关于高等数学你必须知道的二三事', '33针对考研的数学科目，根据各学科、专业对硕士研究生入学所应具备的数学知识和能力的不同要求，硕士研究生入学统考数学试卷分为3种：其中针对工科类的为数学一、数学二；针对经济学和管理学类的为数学三（2009年之前管理类为数学三，经济类为数学四，2009年之后大纲将数学三数学四合并）。具体不同专业所使用的试卷种类有具体规定。', 'jingenqiang', 12, 5, 'article', '2020-11-13 22:10:24', '2020-11-13 22:10:32', '2020-11-13 22:10:36', 1, 'sx', NULL, NULL),
	(4, '如何高效学习数学，备考必须了解i的事情', '44针对考研的数学科目，根据各学科、专业对硕士研究生入学所应具备的数学知识和能力的不同要求，硕士研究生入学统考数学试卷分为3种：其中针对工科类的为数学一、数学二；针对经济学和管理学类的为数学三（2009年之前管理类为数学三，经济类为数学四，2009年之后大纲将数学三数学四合并）。具体不同专业所使用的试卷种类有具体规定。', 'jingenqiang', 12, 5, 'article', '2020-11-13 22:10:24', '2020-11-13 22:10:32', '2020-11-13 22:10:36', 1, 'sx', NULL, NULL),
	(5, '管理类为数学三，经济类为数学四，2009年之后大纲将数学三数学四合并', '55针对考研的数学科目，55根据各学科、专业对硕士研究生入学所应具备的数学知识和能力的不同要求，硕士研究生入学统考数学试卷分为3种：其中针对工科类的为数学一、数学二；针对经济学和管理学类的为数学三（2009年之前管理类为数学三，经济类为数学四，2009年之后大纲将数学三数学四合并）。具体不同专业所使用的试卷种类有具体规定。', 'jingenqiang', 12, 5, 'article', '2020-11-13 22:10:24', '2020-11-13 22:10:32', '2020-11-13 22:10:36', 1, 'sx', NULL, NULL),
	(6, '从2010年开始，全国硕士研究生入学考试的英语试卷分为了英语（一）和英语（二）', '66考生应掌握下列语言知识和技能：除掌握词汇的基本含义外，考生还应掌握词汇之间的词义关系，如同义词、近义词、反义词等；掌握词汇之间的搭配关系，如动词与介词、形容词与介词、形容词与名词等；掌握词汇生成的基本知识，如词源、词根、词缀等。', 'jingenqiang', 12, 5, 'article', '2020-11-13 22:10:24', '2020-11-13 22:10:32', '2020-11-13 22:10:36', 1, 'yy', NULL, NULL),
	(7, '这是一篇非常有用的文章，测试', '7在学习过程的中遇到什么问题，比如说，学习效率怎么提高，学习时间怎么延长这些问题的时候，再回头去查一些经验贴，看一些学长学姐他们是怎么解决这些问题的。', 'jingenqiang', 12, 5, 'article', '2020-11-13 22:10:24', '2020-11-13 22:10:32', '2020-11-13 22:10:36', 1, 'at', NULL, NULL),
	(8, '这是历年以来的真题汇总（各个学科）', '8888ED分词主要考查ED分词与逻辑主语的关系和在复合结构中的运用。从句包括定语从句和状语从句等，他们的存在使句子的结构更为复杂，让考生更难看明白句子的成分，从句也是英译汉的重要考查点。', 'jingenqiang', 12, 5, 'article', '2020-11-13 22:10:24', '2020-11-13 22:10:32', '2020-11-13 22:10:36', 1, 'zt', NULL, NULL),
	(9, '张老师讲数学', '这是内容', 'jingenqiang', 12, 5, 'video', '2020-11-13 22:10:24', '2020-11-13 22:10:32', '2020-11-13 22:10:36', 1, 'zt', 'example/video-1.png', NULL),
	(10, '对于考研语法如何复习，考生首先需要解决一个认识上的误区', '10ED分词主要考查ED分词与逻辑主语的关系和在复合结构中的运用。从句包括定语从句和状语从句等，他们的存在使句子的结构更为复杂，让考生更难看明白句子的成分，从句也是英译汉的重要考查点。', 'jingenqiang', 12, 5, 'article', '2020-11-13 22:10:24', '2020-11-13 22:10:32', '2020-11-13 22:10:36', 1, 'zt', NULL, NULL),
	(11, '英语阅读理解学习', '这是内容', 'jingenqiang', 12, 5, 'video', '2020-11-13 22:10:24', '2020-11-13 22:10:32', '2020-11-13 22:10:36', 1, 'zt', 'example/video-2.png', NULL),
	(12, '如何学好政治', '这是内容', 'jingenqiang', 12, 5, 'video', '2020-11-13 22:10:24', '2020-11-13 22:10:32', '2020-11-13 22:10:36', 1, 'zt', 'example/video-3.png', NULL),
	(13, '数学一精品课程', '这是内容', 'jingenqiang', 12, 5, 'video', '2020-11-13 22:10:24', '2020-11-13 22:10:32', '2020-11-13 22:10:36', 1, 'zt', 'example/video-4.png', NULL),
	(14, '英语真题讲解', '这是内容', 'jingenqiang', 12, 5, 'video', '2020-11-13 22:10:24', '2020-11-13 22:10:32', '2020-11-13 22:10:36', 1, 'zt', 'example/video-5.png', NULL),
	(15, '专业课学习思路', '这是内容', 'jingenqiang', 12, 5, 'video', '2020-11-13 22:10:24', '2020-11-13 22:10:32', '2020-11-13 22:10:36', 1, 'zt', 'example/video-3.png', NULL),
	(16, '阅读理解，该部分由A、B、C三节组成，考查考生理解书面英语的能力', '16考生应掌握下列语言知识和技能：除掌握词汇的基本含义外，考生还应掌握词汇之间的词义关系，如同义词、近义词、反义词等；掌握词汇之间的搭配关系，如动词与介词、形容词与介词、形容词与名词等；掌握词汇生成的基本知识，如词源、词根、词缀等。', 'jingenqiang', 12, 5, 'article', '2020-11-13 22:10:24', '2020-11-13 22:10:32', '2020-11-13 22:10:36', 1, 'yy', NULL, NULL),
	(17, '英语知识运用，该部分不仅考查考生对不同语境中规范的语言要素', '17考生应掌握下列语言知识和技能：除掌握词汇的基本含义外，考生还应掌握词汇之间的词义关系，如同义词、近义词、反义词等；掌握词汇之间的搭配关系，如动词与介词、形容词与介词、形容词与名词等；掌握词汇生成的基本知识，如词源、词根、词缀等。', 'jingenqiang', 12, 5, 'article', '2020-11-13 22:10:24', '2020-11-13 22:10:32', '2020-11-13 22:10:36', 1, 'yy', NULL, NULL),
	(18, '试题分三部分，共52题，包括英语知识运用、阅读理解和写作', '88考生应掌握下列语言知识和技能：除掌握词汇的基本含义外，考生还应掌握词汇之间的词义关系，如同义词、近义词、反义词等；掌握词汇之间的搭配关系，如动词与介词、形容词与介词、形容词与名词等；掌握词汇生成的基本知识，如词源、词根、词缀等。', 'jingenqiang', 12, 5, 'article', '2020-11-13 22:10:24', '2020-11-13 22:10:32', '2020-11-13 22:10:36', 1, 'yy', NULL, NULL),
	(19, '英语（一）即原研究生入学统考“英语”，所有学术型硕士研究生', '77考生应掌握下列语言知识和技能：除掌握词汇的基本含义外，考生还应掌握词汇之间的词义关系，如同义词、近义词、反义词等；掌握词汇之间的搭配关系，如动词与介词、形容词与介词、形容词与名词等；掌握词汇生成的基本知识，如词源、词根、词缀等。', 'jingenqiang', 12, 5, 'article', '2020-11-13 22:10:24', '2020-11-13 22:10:32', '2020-11-13 22:10:36', 1, 'yy', NULL, NULL),
	(20, '长难句的理解，包括快速准确地理解这个句子的成分', '20ED分词主要考查ED分词与逻辑主语的关系和在复合结构中的运用。从句包括定语从句和状语从句等，他们的存在使句子的结构更为复杂，让考生更难看明白句子的成分，从句也是英译汉的重要考查点。', 'jingenqiang', 12, 5, 'article', '2020-11-13 22:10:24', '2020-11-13 22:10:32', '2020-11-13 22:10:36', 1, 'zt', NULL, NULL),
	(21, '结合历年英语真题中经常出现的语法难点和重点', '21D分词主要考查ED分词与逻辑主语的关系和在复合结构中的运用。从句包括定语从句和状语从句等，他们的存在使句子的结构更为复杂，让考生更难看明白句子的成分，从句也是英译汉的重要考查点。', 'jingenqiang', 12, 5, 'article', '2020-11-13 22:10:24', '2020-11-13 22:10:32', '2020-11-13 22:10:36', 1, 'zt', NULL, NULL),
	(22, '已经有几十个回答，你只需要看其中的一到两篇', '22在学习过程的中遇到什么问题，比如说，学习效率怎么提高，学习时间怎么延长这些问题的时候，再回头去查一些经验贴，看一些学长学姐他们是怎么解决这些问题的。', 'jingenqiang', 12, 5, 'article', '2020-11-13 22:10:24', '2020-11-13 22:10:32', '2020-11-13 22:10:36', 1, 'at', NULL, NULL),
	(23, '本文总结了大量考研优秀回答并加入了学长考研过程中自己的一些经验', '23在学习过程的中遇到什么问题，比如说，学习效率怎么提高，学习时间怎么延长这些问题的时候，再回头去查一些经验贴，看一些学长学姐他们是怎么解决这些问题的。', 'jingenqiang', 12, 5, 'article', '2020-11-13 22:10:24', '2020-11-13 22:10:32', '2020-11-13 22:10:36', 1, 'at', NULL, NULL),
	(24, '考研规划，看这一篇就够了', '24在学习过程的中遇到什么问题，比如说，学习效率怎么提高，学习时间怎么延长这些问题的时候，再回头去查一些经验贴，看一些学长学姐他们是怎么解决这些问题的。', 'jingenqiang', 12, 5, 'article', '2020-11-13 22:10:24', '2020-11-13 22:10:32', '2020-11-13 22:10:36', 1, 'at', NULL, NULL);
/*!40000 ALTER TABLE `so_all_content` ENABLE KEYS */;

-- 导出  表 study.so_article 结构
CREATE TABLE IF NOT EXISTS `so_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NOT NULL COMMENT '文章id',
  `article` longtext COLLATE utf8_bin COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  study.so_article 的数据：~18 rows (大约)
/*!40000 ALTER TABLE `so_article` DISABLE KEYS */;
INSERT INTO `so_article` (`id`, `article_id`, `article`) VALUES
	(1, 1, '<h1>1 这是第一章</h1><p>	edit1.我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br/></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br/></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br/></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br/></p>'),
	(2, 2, '<h1>e2.1 这是第一章</h1><p>	我就发了一片文章。0121212</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p>'),
	(3, 3, '<h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p>'),
	(4, 4, '<h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p>'),
	(5, 5, '<h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p>'),
	(6, 6, '<h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p>'),
	(7, 7, '<h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p>'),
	(8, 8, '<h1>8</h1><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p>'),
	(9, 10, '<h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p>'),
	(10, 16, '<h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p>'),
	(11, 17, '<h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p>'),
	(12, 18, '<h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p>'),
	(13, 19, '<h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p>'),
	(14, 20, '<h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p>'),
	(15, 21, '<h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p>'),
	(16, 22, '<h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p>'),
	(17, 23, '<h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p>'),
	(18, 24, '<h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p><h1>1 这是第一章</h1><p>	我就发了一片文章。</p><h1>2 这是第二章</h1><pre class="ql-syntax" spellcheck="false"> console.log(1);\n</pre><p><br></p>');
/*!40000 ALTER TABLE `so_article` ENABLE KEYS */;

-- 导出  表 study.so_config 结构
CREATE TABLE IF NOT EXISTS `so_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `key` char(20) COLLATE utf8_bin DEFAULT NULL COMMENT '关键字',
  `value` char(50) COLLATE utf8_bin DEFAULT NULL COMMENT '值',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `group` char(20) COLLATE utf8_bin DEFAULT NULL COMMENT '分组',
  `is_must` int(11) DEFAULT NULL COMMENT '是否必须，必须则不可删除',
  `about` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '更多说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  study.so_config 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `so_config` DISABLE KEYS */;
INSERT INTO `so_config` (`id`, `key`, `value`, `name`, `group`, `is_must`, `about`) VALUES
	(1, 'experience', 'zt', '考研真题', 'home', 1, NULL),
	(2, 'experience', 'sx', '数学学习', 'home', 1, NULL),
	(3, 'experience', 'yy', '英语学习', 'home', 1, NULL),
	(4, 'experience', 'at', '干货资料', 'home', 1, NULL);
/*!40000 ALTER TABLE `so_config` ENABLE KEYS */;

-- 导出  表 study.so_discuss 结构
CREATE TABLE IF NOT EXISTS `so_discuss` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_id` int(11) DEFAULT NULL COMMENT '评论主题ID',
  `topic_type` char(50) COLLATE utf8_bin DEFAULT 'article' COMMENT '主题类型',
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '评论内容',
  `user_id` int(11) DEFAULT NULL COMMENT '评论用户ID',
  `discuss_time` datetime DEFAULT NULL COMMENT '评论时间',
  `update_time` datetime DEFAULT '1000-01-01 00:00:00' COMMENT '修改时间',
  `deleted_time` datetime DEFAULT '1000-01-01 00:00:00' COMMENT '删除时间',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `floor` int(11) DEFAULT NULL COMMENT '楼数',
  `up_times` int(6) DEFAULT '0' COMMENT '点赞次数',
  `re_times` int(5) DEFAULT '0' COMMENT '回复次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  study.so_discuss 的数据：~7 rows (大约)
/*!40000 ALTER TABLE `so_discuss` DISABLE KEYS */;
INSERT INTO `so_discuss` (`id`, `topic_id`, `topic_type`, `content`, `user_id`, `discuss_time`, `update_time`, `deleted_time`, `status`, `floor`, `up_times`, `re_times`) VALUES
	(1, 1, 'article', '这篇文章真不错我已经更新了，但是没有在文章下面找到禁止转载功能啊？是不是要加入公测群才行啊，我也下载了没找到可dfdadf以直接在原有的简书软件上更新下载吗？', 1, '2020-11-15 18:58:05', '2020-11-15 18:58:08', '2020-11-15 18:58:10', 1, 1, 1, 3),
	(2, 1, 'article', '我赞同这篇文章', 2, '2020-11-15 19:17:55', '2020-11-15 19:17:58', '2020-11-15 19:18:01', 1, 2, 2, 3),
	(13, 8, 'article', '文章8测试', 1, '2021-03-23 16:57:35', '1000-01-01 00:00:00', '1000-01-01 00:00:00', 1, 1, 0, 0),
	(14, 8, 'article', '文章8测试-2', 1, '2021-03-23 16:57:54', '1000-01-01 00:00:00', '1000-01-01 00:00:00', 1, 2, 0, 0),
	(15, 8, 'article', '文章8评论-3', 1, '2021-03-23 17:00:06', '1000-01-01 00:00:00', '1000-01-01 00:00:00', 1, 3, 0, 0),
	(16, 8, 'article', '文章8评论-4', 1, '2021-03-23 17:03:07', '1000-01-01 00:00:00', '1000-01-01 00:00:00', 1, 4, 0, 0),
	(17, 8, 'article', '评论802', 1, '2021-03-24 10:46:21', '1000-01-01 00:00:00', '1000-01-01 00:00:00', 1, 5, 0, 0);
/*!40000 ALTER TABLE `so_discuss` ENABLE KEYS */;

-- 导出  表 study.so_discuss_reply 结构
CREATE TABLE IF NOT EXISTS `so_discuss_reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '回复的内容',
  `topic_id` int(11) DEFAULT NULL COMMENT '主题ID',
  `discuss_id` int(11) DEFAULT NULL COMMENT '回复目标ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `reply_time` datetime DEFAULT NULL COMMENT '回复时间',
  `update_time` datetime DEFAULT '1000-10-10 00:00:00' COMMENT '更新时间',
  `deleted_time` datetime DEFAULT '1000-10-10 00:00:00' COMMENT '删除时间',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `floor` int(11) DEFAULT NULL COMMENT '层数',
  `reply_id` int(11) DEFAULT NULL COMMENT '回复回复',
  `up_times` int(6) DEFAULT '0' COMMENT '点赞次数',
  `re_times` int(5) DEFAULT '0' COMMENT '被回复次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  study.so_discuss_reply 的数据：~21 rows (大约)
/*!40000 ALTER TABLE `so_discuss_reply` DISABLE KEYS */;
INSERT INTO `so_discuss_reply` (`id`, `content`, `topic_id`, `discuss_id`, `user_id`, `reply_time`, `update_time`, `deleted_time`, `status`, `floor`, `reply_id`, `up_times`, `re_times`) VALUES
	(1, '你说的对', 1, 1, 2, '2020-11-15 19:19:13', '2020-11-15 19:19:17', '2020-11-15 19:19:19', 1, 1, 0, 12, 2),
	(2, '谢谢', 1, 1, 1, '2020-11-15 19:26:59', '2020-11-15 19:27:03', '2020-11-15 19:27:05', 1, 2, 1, 22, 1),
	(3, '哈哈哈', 1, 2, 1, '2020-11-16 18:50:11', '2020-11-16 18:50:14', '2020-11-16 18:50:20', 1, 1, 0, 11, 2),
	(4, '司法降低1221', 1, 1, 1, '2021-03-24 11:20:17', '1000-10-10 00:00:00', '1000-10-10 00:00:00', 1, 3, 2, 0, 0),
	(5, '第4层了', 1, 1, 1, '2021-03-24 11:22:02', '1000-10-10 00:00:00', '1000-10-10 00:00:00', 1, 4, 0, 0, 0),
	(6, '测试回复', 8, 13, 1, '2021-03-24 14:11:44', '1000-10-10 00:00:00', '1000-10-10 00:00:00', 1, 1, 0, 0, 0),
	(8, '测试s1', 8, 13, 1, '2021-03-24 14:35:04', '1000-10-10 00:00:00', '1000-10-10 00:00:00', 1, 2, 1, 0, 0),
	(9, '搜索', 8, 13, 1, '2021-03-24 14:36:09', '1000-10-10 00:00:00', '1000-10-10 00:00:00', 1, 3, 2, 0, 0),
	(10, '测试', 8, 13, 1, '2021-03-24 14:37:00', '1000-10-10 00:00:00', '1000-10-10 00:00:00', 1, 4, 2, 0, 0),
	(11, '得到', 8, 14, 1, '2021-03-24 14:37:34', '1000-10-10 00:00:00', '1000-10-10 00:00:00', 1, 1, 0, 0, 0),
	(12, '得到', 8, 14, 1, '2021-03-24 14:39:18', '1000-10-10 00:00:00', '1000-10-10 00:00:00', 1, 2, 0, 0, 0),
	(13, '的', 8, 14, 1, '2021-03-24 14:41:55', '1000-10-10 00:00:00', '1000-10-10 00:00:00', 1, 3, 2, 0, 0),
	(14, '我 ', 8, 14, 1, '2021-03-24 14:42:07', '1000-10-10 00:00:00', '1000-10-10 00:00:00', 1, 4, 2, 0, 0),
	(15, '测试', 8, 17, 1, '2021-03-24 14:46:22', '1000-10-10 00:00:00', '1000-10-10 00:00:00', 1, 1, 0, 0, 0),
	(16, '12123123', 8, 17, 1, '2021-03-24 14:51:46', '1000-10-10 00:00:00', '1000-10-10 00:00:00', 1, 2, 0, 0, 0),
	(17, '1', 8, 16, 1, '2021-03-24 14:55:12', '1000-10-10 00:00:00', '1000-10-10 00:00:00', 1, 1, 0, 0, 0),
	(18, '2额', 8, 16, 1, '2021-03-24 14:56:08', '1000-10-10 00:00:00', '1000-10-10 00:00:00', 1, 2, 0, 0, 0),
	(19, 's的', 8, 15, 1, '2021-03-24 14:57:20', '1000-10-10 00:00:00', '1000-10-10 00:00:00', 1, 1, 0, 0, 0),
	(20, '而微软威威', 8, 15, 1, '2021-03-24 14:57:41', '1000-10-10 00:00:00', '1000-10-10 00:00:00', 1, 2, 0, 0, 0),
	(21, '十分士大夫', 8, 16, 1, '2021-03-24 14:58:48', '1000-10-10 00:00:00', '1000-10-10 00:00:00', 1, 3, 0, 0, 0),
	(22, 's打发士大夫士大夫', 8, 16, 1, '2021-03-24 15:00:43', '1000-10-10 00:00:00', '1000-10-10 00:00:00', 1, 4, 0, 0, 0);
/*!40000 ALTER TABLE `so_discuss_reply` ENABLE KEYS */;

-- 导出  表 study.so_menulist 结构
CREATE TABLE IF NOT EXISTS `so_menulist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_key` char(50) COLLATE utf8_bin DEFAULT NULL COMMENT '菜单关键字',
  `menu_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '菜单名',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `menu_level` int(11) DEFAULT NULL COMMENT '菜单等级',
  `parent_ment` int(11) DEFAULT NULL COMMENT '父级菜单',
  `menu_order` int(11) DEFAULT NULL COMMENT '菜单顺序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  study.so_menulist 的数据：~9 rows (大约)
/*!40000 ALTER TABLE `so_menulist` DISABLE KEYS */;
INSERT INTO `so_menulist` (`id`, `menu_key`, `menu_name`, `status`, `menu_level`, `parent_ment`, `menu_order`) VALUES
	(1, 'all', '总览', 1, 1, 0, 1),
	(2, 'myInformation', '我的信息', 1, 1, 0, 2),
	(3, 'classPage', '我的课程', 1, 2, 2, 1),
	(4, 'personPage', '个人资料', 1, 2, 2, 2),
	(5, 'articlePage', '我的文章', 1, 2, 2, 3),
	(6, 'questionPage', '我的提问', 1, 2, 2, 4),
	(7, 'sysPage', '系统相关', 1, 1, 0, 3),
	(8, 'scorePage', '积分商城', 1, 2, 7, 1),
	(9, 'noticePage', '系统通知', 1, 2, 7, 2);
/*!40000 ALTER TABLE `so_menulist` ENABLE KEYS */;

-- 导出  表 study.so_menu_promise 结构
CREATE TABLE IF NOT EXISTS `so_menu_promise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_key` char(50) COLLATE utf8_bin DEFAULT NULL COMMENT '菜单键',
  `user_role` char(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户角色',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  study.so_menu_promise 的数据：~7 rows (大约)
/*!40000 ALTER TABLE `so_menu_promise` DISABLE KEYS */;
INSERT INTO `so_menu_promise` (`id`, `menu_key`, `user_role`, `status`) VALUES
	(1, 'all', 'common', NULL),
	(2, 'myInformation', 'common', NULL),
	(3, 'classPage', 'common', NULL),
	(4, 'personPage', 'common', NULL),
	(5, 'articlePage', 'common', NULL),
	(7, 'sysPage', 'common', NULL),
	(9, 'noticePage', 'common', NULL);
/*!40000 ALTER TABLE `so_menu_promise` ENABLE KEYS */;

-- 导出  表 study.so_user 结构
CREATE TABLE IF NOT EXISTS `so_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `user_no` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '账号',
  `password` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `user_name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '用户姓名',
  `user_type` int(11) DEFAULT NULL COMMENT '用户类型',
  `user_role` char(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户角色',
  `gander` int(11) DEFAULT NULL COMMENT '用户性别',
  `email` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `phone` char(11) COLLATE utf8_bin DEFAULT NULL COMMENT '手机',
  `tel` char(20) COLLATE utf8_bin DEFAULT NULL COMMENT '座机',
  `desc` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '简介',
  `theme` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '颜色主题',
  `user_img` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户头像',
  `cover_img` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户封面',
  `tags` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户标签',
  `token` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '用户token',
  `creation_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creating_by` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `userNo` (`user_no`) USING BTREE,
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  study.so_user 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `so_user` DISABLE KEYS */;
INSERT INTO `so_user` (`id`, `user_no`, `password`, `user_name`, `user_type`, `user_role`, `gander`, `email`, `phone`, `tel`, `desc`, `theme`, `user_img`, `cover_img`, `tags`, `token`, `creation_time`, `creating_by`, `update_time`, `update_by`) VALUES
	(1, 'jing', 'jing', '静夜思', 1, 'common', 1, 'jeq@mail.com', '19906613838', '0571-09099', NULL, NULL, NULL, NULL, NULL, 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJqaW5nIiwiZXhwIjoxNjUyMzYyMjUwLCJpYXQiOjE2NTIzNTUwNTB9.MIXPxuj5FaxCdPSZSroldfseIHA_3kZjqCHF3zb6dCU', NULL, NULL, NULL, NULL),
	(2, 'en', 'en', '青空', 2, 'admin', 2, 'qk@email.com', '19909982822', '091029', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `so_user` ENABLE KEYS */;

-- 导出  表 study.so_verify_code 结构
CREATE TABLE IF NOT EXISTS `so_verify_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `find_ip` char(20) COLLATE utf8_bin DEFAULT NULL COMMENT 'IP',
  `add_time` bigint(20) DEFAULT NULL COMMENT '添加时间',
  `code_value` char(6) COLLATE utf8_bin DEFAULT NULL COMMENT '验证码值',
  `status` int(11) DEFAULT NULL COMMENT '是否使用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  study.so_verify_code 的数据：~10 rows (大约)
/*!40000 ALTER TABLE `so_verify_code` DISABLE KEYS */;
INSERT INTO `so_verify_code` (`id`, `find_ip`, `add_time`, `code_value`, `status`) VALUES
	(1, '0:0:0:0:0:0:0:1', 1604927460091, '5006', 0),
	(2, '0:0:0:0:0:0:0:1', 1604941568358, '6170', 0),
	(3, '0:0:0:0:0:0:0:1', 1604941601681, '8207', 0),
	(4, '0:0:0:0:0:0:0:1', 1604941746534, '3465', 0),
	(5, '0:0:0:0:0:0:0:1', 1604941753709, '7274', 0),
	(6, '0:0:0:0:0:0:0:1', 1604969187837, '2060', 0),
	(7, '0:0:0:0:0:0:0:1', 1604969232417, '8136', 0),
	(8, '0:0:0:0:0:0:0:1', 1604969246614, '3818', 0),
	(9, '0:0:0:0:0:0:0:1', 1604969845194, '8705', 0),
	(10, '0:0:0:0:0:0:0:1', 1604971359583, '7654', 0);
/*!40000 ALTER TABLE `so_verify_code` ENABLE KEYS */;

-- 导出  表 study.so_video_chapter 结构
CREATE TABLE IF NOT EXISTS `so_video_chapter` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `video_id` int(11) DEFAULT NULL COMMENT '视频ID',
  `part` int(11) DEFAULT NULL COMMENT '视频分卷',
  `part_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '卷名',
  `chapter` int(11) DEFAULT NULL COMMENT '视频分节',
  `chapter_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '节名',
  `link_url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT 'url地址',
  `extrai` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '备用一',
  `extraii` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '备用二',
  `extraiii` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '备用三',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  study.so_video_chapter 的数据：~27 rows (大约)
/*!40000 ALTER TABLE `so_video_chapter` DISABLE KEYS */;
INSERT INTO `so_video_chapter` (`id`, `video_id`, `part`, `part_name`, `chapter`, `chapter_name`, `link_url`, `extrai`, `extraii`, `extraiii`) VALUES
	(1, 9, 1, '第一部', 1, '考研英语词汇解析', 'ffis', NULL, NULL, NULL),
	(2, 9, 1, '第一部', 12, '考研英语词汇解析12', 'ffis', NULL, NULL, NULL),
	(3, 9, 1, '第一部', 11, '考研英语词汇解析11', 'ffis', NULL, NULL, NULL),
	(4, 9, 1, '第一部', 10, '考研英语词汇解析10', 'ffis', NULL, NULL, NULL),
	(5, 9, 1, '第一部', 9, '考研英语词汇解析9', 'ffis', NULL, NULL, NULL),
	(6, 9, 1, '第一部', 8, '考研英语词汇解析8', 'ffis', NULL, NULL, NULL),
	(7, 9, 1, '第一部', 7, '考研英语词汇解析7', 'ffis', NULL, NULL, NULL),
	(8, 9, 1, '第一部', 7, '考研英语词汇解析7', 'ffis', NULL, NULL, NULL),
	(9, 9, 1, '第一部', 6, '考研英语词汇解析6', 'ffis', NULL, NULL, NULL),
	(10, 9, 1, '第一部', 5, '考研英语词汇解析5', 'ffis', NULL, NULL, NULL),
	(11, 9, 1, '第一部', 4, '考研英语词汇解析4', 'ffis', NULL, NULL, NULL),
	(12, 9, 1, '第一部', 3, '考研英语词汇解析3', 'ffis', NULL, NULL, NULL),
	(13, 9, 1, '第一部', 2, '考研英语词汇解析2', 'ffis', NULL, NULL, NULL),
	(14, 11, 1, '第一部', 1, '考研数学1', 'ffis', NULL, NULL, NULL),
	(15, 11, 1, '第一部', 2, '考研数学2', 'ffis', NULL, NULL, NULL),
	(16, 11, 1, '第一部', 3, '考研数学3', 'ffis', NULL, NULL, NULL),
	(17, 11, 1, '第一部', 4, '考研数学4', 'ffis', NULL, NULL, NULL),
	(18, 12, 1, '第一部', 1, '考研政治1', 'ffis', NULL, NULL, NULL),
	(19, 12, 1, '第一部', 2, '考研政治2', 'ffis', NULL, NULL, NULL),
	(20, 12, 1, '第一部', 3, '考研政治3', 'ffis', NULL, NULL, NULL),
	(21, 12, 1, '第一部', 4, '考研政治4', 'ffis', NULL, NULL, NULL),
	(22, 13, 1, '第一部', 1, '其他学习1', 'ffis', NULL, NULL, NULL),
	(23, 13, 1, '第一部', 2, '其他学习2', 'ffis', NULL, NULL, NULL),
	(24, 13, 1, '第一部', 3, '其他学习3', 'ffis', NULL, NULL, NULL),
	(25, 13, 1, '第一部', 4, '其他学习4', 'ffis', NULL, NULL, NULL),
	(26, 13, 1, '第一部', 5, '其他学习5', 'ffis', NULL, NULL, NULL),
	(27, 13, 1, '第一部', 5, '其他学习6', 'ffis', NULL, NULL, NULL);
/*!40000 ALTER TABLE `so_video_chapter` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
