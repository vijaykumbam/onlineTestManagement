INSERT INTO `onlinetestmanagement`.`user_table` (`user_id`, `password`, `role`, `user_name`) VALUES ('11606974', 'fsfafa', 'user', 'vijay');
INSERT INTO `onlinetestmanagement`.`user_table` (`user_id`, `password`, `role`, `user_name`) VALUES ('11606975', 'jgfjgf', 'user', 'vijay');
INSERT INTO `onlinetestmanagement`.`user_table` (`user_id`, `password`, `role`, `user_name`) VALUES ('11606976', 'fjfjytjy', 'user', 'vijay');




INSERT INTO `onlinetestmanagement`.`online_test` (`exam_id`, `exam_name`, `minutes`) VALUES ('2000', 'java', '40');
INSERT INTO `onlinetestmanagement`.`online_test` (`exam_id`, `exam_name`, `minutes`) VALUES ('2001', 'dotnet', '40');
INSERT INTO `onlinetestmanagement`.`online_test` (`exam_id`, `exam_name`, `minutes`) VALUES ('2002', 'python', '40');



INSERT INTO `onlinetestmanagement`.`assign_exam_to_user` (`assigned_id`, `date_of_exam`, `marks`, `status`, `exam_id`, `user_id`) VALUES ('123451', '2020-05-02', '25', TRUE, '2000', '11606974');
INSERT INTO `onlinetestmanagement`.`assign_exam_to_user` (`assigned_id`, `date_of_exam`, `marks`, `status`, `exam_id`, `user_id`) VALUES ('123452', '2020-05-02', '25', TRUE, '2001', '11606975');
INSERT INTO `onlinetestmanagement`.`assign_exam_to_user` (`assigned_id`, `date_of_exam`, `marks`, `status`, `exam_id`, `user_id`) VALUES ('123453', '2020-05-02', '25', TRUE, '2002', '11606975');
INSERT INTO `onlinetestmanagement`.`assign_exam_to_user` (`assigned_id`, `date_of_exam`, `marks`, `status`, `exam_id`, `user_id`) VALUES ('123454', '2020-06-12', '30', TRUE, '2000', '11606974');
INSERT INTO `onlinetestmanagement`.`assign_exam_to_user` (`assigned_id`, `date_of_exam`, `marks`, `status`, `exam_id`, `user_id`) VALUES ('123455', '2020-06-12', '30', TRUE, '2002', '11606974');
