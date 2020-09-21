INSERT INTO `onlinetestmanagement`.`user_table` (`user_id`, `password`, `role`, `user_name`) VALUES ('1', 'fsfafa', 'user', 'vijay');
INSERT INTO `onlinetestmanagement`.`user_table` (`user_id`, `password`, `role`, `user_name`) VALUES ('2', 'jgfjgf', 'user', 'vijay');
INSERT INTO `onlinetestmanagement`.`user_table` (`user_id`, `password`, `role`, `user_name`) VALUES ('3', 'fjfjytjy', 'user', 'vijay');




INSERT INTO `onlinetestmanagement`.`online_test` (`exam_id`, `exam_name`, `minutes`) VALUES ('11', 'java', '40');
INSERT INTO `onlinetestmanagement`.`online_test` (`exam_id`, `exam_name`, `minutes`) VALUES ('12', 'dotnet', '40');
INSERT INTO `onlinetestmanagement`.`online_test` (`exam_id`, `exam_name`, `minutes`) VALUES ('13', 'python', '40');



INSERT INTO `onlinetestmanagement`.`assign_exam_to_user` (`assigned_id`, `date_of_exam`, `marks`, `status`, `exam_id`, `user_id`) VALUES ('1232', '2020-05-02', '25', TRUE, '11', '1');
INSERT INTO `onlinetestmanagement`.`assign_exam_to_user` (`assigned_id`, `date_of_exam`, `marks`, `status`, `exam_id`, `user_id`) VALUES ('1233', '2020-05-02', '25', TRUE, '12', '2');
INSERT INTO `onlinetestmanagement`.`assign_exam_to_user` (`assigned_id`, `date_of_exam`, `marks`, `status`, `exam_id`, `user_id`) VALUES ('1234', '2020-05-02', '25', TRUE, '13', '2');
INSERT INTO `onlinetestmanagement`.`assign_exam_to_user` (`assigned_id`, `date_of_exam`, `marks`, `status`, `exam_id`, `user_id`) VALUES ('1235', '2020-06-12', '30', TRUE, '11', '1');
INSERT INTO `onlinetestmanagement`.`assign_exam_to_user` (`assigned_id`, `date_of_exam`, `marks`, `status`, `exam_id`, `user_id`) VALUES ('1236', '2020-06-12', '30', TRUE, '13', '1');
