IF NOT EXISTS(SELECT *
              FROM INFORMATION_SCHEMA.TABLES
              WHERE TABLE_NAME = 'member')
  BEGIN
    CREATE TABLE member (
      memberSeq INT IDENTITY(1,1) NOT NULL,
      name NVARCHAR(10) NOT NULL,
      age INT NOT NULL,
      sex BIT NOT NULL,
      address NVARCHAR(50) NULL,
      delYn BIT NOT NULL,
      regDt DATETIME NOT NULL,
      uId VARCHAR(50) NULL,
      upw VARCHAR(50) NULL,
      CONSTRAINT [PK_member] PRIMARY KEY CLUSTERED
  )
  END