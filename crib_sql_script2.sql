SELECT * FROM sitedownloader_schema.tasks;

use sitedownloader_schema;

select idTasks from tasks where endtime is NULL;

-- UPDATE `sitedownloader_schema`.`tasks` SET `endTime`='2017-07-27 11:08:01' WHERE `idTasks`='1';

-- INSERT INTO `sitedownloader_schema`.`tasks` (`startTime`) VALUES ('2017-07-27 11:08:02');
