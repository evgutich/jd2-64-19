CREATE TABLE monograph
(
    id          BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT,
    type        VARCHAR(255) NOT NULL,
    title       VARCHAR(255) NOT NULL,
    edition     VARCHAR(255) NOT NULL,
    author_id   BIGINT       NOT NULL,
    printRun    INT          NOT NULL,
    pages       INT          NOT NULL,
    entryDate   DATETIME     NOT NULL
)