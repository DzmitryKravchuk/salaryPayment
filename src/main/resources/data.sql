INSERT INTO "division" (CODE, DESCRIPTION) VALUES
                                            ('BA', 'Business-analysts'),
                                            ('QA', 'Quality assurance'),
                                            ('Java', 'Lava division'),
                                            ('.Net', '.Net division'),
                                            ('PHP', 'PHP division');

INSERT INTO "user" (LOGIN, PASSWORD, DIVISION_ID) VALUES
                                               ('BA', 'changeit', 1),
                                               ('QA', 'changeit', 2),
                                               ('.Net', 'changeit', 4),
                                               ('PHP', 'changeit', 5);