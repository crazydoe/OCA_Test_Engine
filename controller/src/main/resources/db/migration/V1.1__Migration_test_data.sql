########## QUESTION TABLE DATA ################
# ----1
INSERT INTO question (title, body, footer, body_type, answer_type, visible)
VALUES ('Given','
1.    int []a = {1,2,3,4,5,6}; \\n
2.    int i = a.length - 1; \\n
3. \\n
4.    while(i>=0){ \\n
5.    System.out.print(a[i]); \\n
6.      i--; \\n
7.    } ',
        'What is the result?', 'CODE', 'SINGLE', TRUE);

# ------2
INSERT INTO question (title, body, footer, body_type, answer_type, visible)
VALUES ('Given','
1.  class Ex6{ \\n
2.  public static void main(String args[]){ \\n
3.    int x = 0, y=10; \\n
4.      try{ \\n
5.        y /=x; \\n
6.        } \\n
7.    System.out.print("/ by 0"); \\n
8.      catch(Exception e){ \\n
9.        System.out.print("error"); \\n
10.      } \\n
11.  }  } ',
        'What is the result?', 'CODE', 'SINGLE', TRUE);

# -----3
INSERT INTO question (title, body, footer, body_type, answer_type, visible)
VALUES ('Given','
- A and E are classes \\n
- B and D are interfaces  \\n
- C is an abstract class',
        'Which are true? (Choose 3)', 'RAW', 'MULTIPLE', TRUE);

# ------4
INSERT INTO question (title, body, footer, body_type, answer_type, visible)
VALUES ('Given','
- A and E are classes \\n
- B and D are interfaces',
        'Which are true? (Choose 2)', 'RAW', 'MULTIPLE', TRUE);

# ------5
INSERT INTO question (title, body, footer, body_type, answer_type, visible)
VALUES ('Given','
1.  class Ex1{ \\n
2.      public static void main(String[] args) { \\n
3.    int a[] = { 1,2,3,4}; \\n
4.  System.out.print(a instanceof Object); \\n
5.      } \\n
6.    } \\n
Note: The keyword "instanceof" is use to check whether an object is of a particular type ',
        'What is the result?', 'CODE', 'SINGLE', TRUE);

# ------6
INSERT INTO question (title, body, footer, body_type, answer_type, visible)
VALUES ('Given','
1.  class Ex1{ \\n
2.    public static void main(String[] args) { \\n
3.      int a[][] = new int[3][]; \\n
4.       a[1] = new int[]{1,2,3}; \\n
5.       a[2] = new int[]{4,5}; \\n
6.    System.out.print(a[1][1]); \\n
7.    } \\n
8.  }',
        'Which is the output?', 'CODE', 'SINGLE', TRUE);

# -------7
INSERT INTO question (title, body_type, answer_type, visible)
VALUES ('Choose the three legal identifiers.','RAW', 'MULTIPLE', TRUE);

# -------8
INSERT INTO question (title, body, footer, body_type, answer_type, visible)
VALUES ('Given','
1.  class Ex1{ \\n
2.    int a=10; \\n
3.      public static void main(String[] args) { \\n
4.     new Ex1().print(); \\n
5.    } \\n
6.  public void print(){ \\n
7.    int a = 8; \\n
8.    System.out.print(a + " "); \\n
9.    } \\n
10.  }',
        'What is the result?', 'CODE', 'SINGLE', TRUE);

# -------9
INSERT INTO question (title, body_type, answer_type, visible)
VALUES ('What primary advantages does the 802.1Q Trunking Protocol offer compared to ISL? (Choose two)',
        'RAW', 'SINGLE', TRUE);

# ------10
INSERT INTO question (title, footer, body_type, answer_type, visible)
VALUES ('Switch B is a Catalyst 2924 switch you''re configuring to support VLAN trunking. Switch B is both ISL
    and 802.1Q capable. Switch A is encapsulating 802.1Q. You want Switch B''s port to be in trunk mode regardless
    of the mode configured on Switch A.',
        'Which commands should you use to configure the trunk port on Switch B? (Choose two)',
        'RAW', 'SINGLE', TRUE);


############### ANSWER TABLE DATA ################
# question: 1
INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('123457', true, 'maybe someone will add one day', 1);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('An exception could be thrown at runtime.', false, 'maybe someone will add one day', 1);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('654321', false, 'maybe someone will add one day', 1);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('nothing', false, 'maybe someone will add one day', 1);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('65432', false, 'maybe someone will add one day', 1);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('12345', false, 'maybe someone will add one day', 1);

# question: 2
INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('0', true, 'maybe someone will add one day', 2);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('error', false, 'maybe someone will add one day', 2);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('Compilation fails ', false, 'maybe someone will add one day', 2);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('No output', false, 'maybe someone will add one day', 2);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('An uncaught exception is thrown at runtime. ', false, 'maybe someone will add one day', 2);

# question: 3
INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('class F implements B,C{ }', true, 'maybe someone will add one day', 3);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('class F implements B{ }', false, 'maybe someone will add one day', 3);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('class Fextends A,E{ }', false, 'maybe someone will add one day', 3);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('class F extends E{ }', true, 'maybe someone will add one day', 3);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('class F implements B,D{ }', true, 'maybe someone will add one day', 3);

# question 4
INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('interface F implements B,D{ }', true, 'maybe someone will add one day', 4);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('interface F implements D{ }', false, 'maybe someone will add one day', 4);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('interface F implements B,C{ }', true, 'maybe someone will add one day', 4);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('interface F implements B,C{ }', false, 'maybe someone will add one day', 4);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('interface F implements B,C{ }', false, 'maybe someone will add one day', 4);

# question 5
INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('Will produce output as false.', true, 'maybe someone will add one day', 5);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('Compilation fails due to error at line 3.', false, 'maybe someone will add one day', 5);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('Will produce output as true.', false, 'maybe someone will add one day', 5);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('Compilation fails due to error at line 4.', false, 'maybe someone will add one day', 5);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('Length of this array is 3.', false, 'maybe someone will add one day', 5);

# question 6
INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('Compilation fails due to line 3', false, 'maybe someone will add one day', 6);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('Compilation fails due to line 4.', true, 'maybe someone will add one day', 6);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('An exception will be thrown in runtime.', false, 'maybe someone will add one day', 6);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('2', false, 'maybe someone will add one day', 6);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('3', false, 'maybe someone will add one day', 6);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('5', false, 'maybe someone will add one day', 6);

# question 7
INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('1stName', false, 'maybe someone will add one day', 7);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('_4_', true, 'maybe someone will add one day', 7);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('@name', true, 'maybe someone will add one day', 7);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES (' $', true, 'maybe someone will add one day', 7);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('getSize', false, 'maybe someone will add one day', 7);

# question 8
INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('10', true, 'maybe someone will add one day', 8);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('Compilation fails. ', false, 'maybe someone will add one day', 8);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('18', false, 'maybe someone will add one day', 8);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('Output is unpredicatable.', false, 'maybe someone will add one day', 8);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('8', false, 'maybe someone will add one day', 8);

# question 9
INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('Both FastEthernet 0/9 and 0/10 are configured as unconditional access ports.',
        false, 'maybe someone will add one day', 9);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('If the switch has default trunk configurations, traffic received on FastEthernet 0/10 will not be tagged.',
        true, 'maybe someone will add one day', 9);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('Traffic received on FastEthernet 0/9 will be sent to FastEthernet 0/10.',
        false, 'maybe someone will add one day', 9);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('FastEthernet 0/9 may begin trunking and tagging traffic if connected to another switch which desires to trunk.',
        false, 'maybe someone will add one day', 9);

# question 10
INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('Both FastEthernet 0/9 and 0/10 are configured as unconditional access ports.',
        false, 'maybe someone will add one day', 10);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('If the switch has default trunk configurations, traffic received on FastEthernet 0/10 will not be tagged.',
        true, 'maybe someone will add one day', 10);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('Traffic received on FastEthernet 0/9 will be sent to FastEthernet 0/10.',
        false, 'maybe someone will add one day', 10);

INSERT INTO answer (body, correct, explanation, question_id)
VALUES ('FastEthernet 0/9 may begin trunking and tagging traffic if connected to another switch which desires to trunk.',
        false, 'maybe someone will add one day', 10);


############# TAG TABLE DATA ##############

INSERT INTO tag (name, description) VALUES ('name of tag 1', 'tag #1');
INSERT INTO tag (name, description) VALUES ('name of tag 2', 'tag #2');
INSERT INTO tag (name, description) VALUES ('name of tag 3', 'tag #3');
INSERT INTO tag (name, description) VALUES ('name of tag 4', 'tag #4');
INSERT INTO tag (name, description) VALUES ('name of tag 5', 'tag #5');


############ CATEGORY TABLE DATA ###############

INSERT INTO category (name, description) VALUES ('name of category 1', 'category #1');
INSERT INTO category (name, description) VALUES ('name of category 2', 'category #2');
INSERT INTO category (name, description) VALUES ('name of category 3', 'category #3');
INSERT INTO category (name, description) VALUES ('name of category 4', 'category #4');
INSERT INTO category (name, description) VALUES ('name of category 5', 'category #5');
INSERT INTO category (name, description) VALUES ('name of category 6', 'category #6');


############ QUESTION_CATEGORY TABLE DATA ###############

INSERT INTO question_category (question_id, category_id) VALUES (1,1);
INSERT INTO question_category (question_id, category_id) VALUES (2,1);
INSERT INTO question_category (question_id, category_id) VALUES (3,1);
INSERT INTO question_category (question_id, category_id) VALUES (4,1);
INSERT INTO question_category (question_id, category_id) VALUES (5,1);
INSERT INTO question_category (question_id, category_id) VALUES (6,1);
INSERT INTO question_category (question_id, category_id) VALUES (7,1);
INSERT INTO question_category (question_id, category_id) VALUES (8,1);
INSERT INTO question_category (question_id, category_id) VALUES (9,2);
INSERT INTO question_category (question_id, category_id) VALUES (10,2);

############# QUESTION_TAG TABLE DATA #################

INSERT INTO question_tag (question_id, tag_id) VALUES (1, 1);
INSERT INTO question_tag (question_id, tag_id) VALUES (1, 2);
INSERT INTO question_tag (question_id, tag_id) VALUES (1, 3);
INSERT INTO question_tag (question_id, tag_id) VALUES (1, 4);

INSERT INTO question_tag (question_id, tag_id) VALUES (2, 1);
INSERT INTO question_tag (question_id, tag_id) VALUES (2, 2);
INSERT INTO question_tag (question_id, tag_id) VALUES (2, 3);
INSERT INTO question_tag (question_id, tag_id) VALUES (2, 4);

INSERT INTO question_tag (question_id, tag_id) VALUES (3, 1);
INSERT INTO question_tag (question_id, tag_id) VALUES (3, 2);
INSERT INTO question_tag (question_id, tag_id) VALUES (3, 3);
INSERT INTO question_tag (question_id, tag_id) VALUES (3, 4);

INSERT INTO question_tag (question_id, tag_id) VALUES (4, 1);
INSERT INTO question_tag (question_id, tag_id) VALUES (4, 2);
INSERT INTO question_tag (question_id, tag_id) VALUES (4, 3);
INSERT INTO question_tag (question_id, tag_id) VALUES (4, 4);

INSERT INTO question_tag (question_id, tag_id) VALUES (5, 1);
INSERT INTO question_tag (question_id, tag_id) VALUES (5, 2);
INSERT INTO question_tag (question_id, tag_id) VALUES (5, 3);
INSERT INTO question_tag (question_id, tag_id) VALUES (5, 4);

INSERT INTO question_tag (question_id, tag_id) VALUES (6, 1);
INSERT INTO question_tag (question_id, tag_id) VALUES (6, 2);
INSERT INTO question_tag (question_id, tag_id) VALUES (6, 3);
INSERT INTO question_tag (question_id, tag_id) VALUES (6, 4);

INSERT INTO question_tag (question_id, tag_id) VALUES (7, 1);
INSERT INTO question_tag (question_id, tag_id) VALUES (7, 2);
INSERT INTO question_tag (question_id, tag_id) VALUES (7, 3);
INSERT INTO question_tag (question_id, tag_id) VALUES (7, 4);

INSERT INTO question_tag (question_id, tag_id) VALUES (8, 1);
INSERT INTO question_tag (question_id, tag_id) VALUES (8, 2);
INSERT INTO question_tag (question_id, tag_id) VALUES (8, 3);
INSERT INTO question_tag (question_id, tag_id) VALUES (8, 4);

INSERT INTO question_tag (question_id, tag_id) VALUES (9, 1);
INSERT INTO question_tag (question_id, tag_id) VALUES (9, 2);
INSERT INTO question_tag (question_id, tag_id) VALUES (9, 3);
INSERT INTO question_tag (question_id, tag_id) VALUES (9, 4);

INSERT INTO question_tag (question_id, tag_id) VALUES (10, 1);
INSERT INTO question_tag (question_id, tag_id) VALUES (10, 2);
INSERT INTO question_tag (question_id, tag_id) VALUES (10, 3);
INSERT INTO question_tag (question_id, tag_id) VALUES (10, 4);