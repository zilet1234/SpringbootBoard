IF NOT EXISTS(SELECT *
              FROM INFORMATION_SCHEMA.TABLES
              WHERE TABLE_NAME = 'Member')
  BEGIN
    CREATE TABLE [dbo].[Member](
        [MemberSeq] [int] IDENTITY(1,1) NOT NULL,
        [Uid] [varchar](50) NOT NULL,
        [Upw] [varchar](50) NOT NULL,
        [Name] [nvarchar](10) NULL,
        [Age] [int] NULL,
        [Sex] [int] NULL,
        [Address] [nvarchar](100) NULL,
        [RegDT] [datetime] NOT NULL,
        [DelYN] [bit] NOT NULL,
     CONSTRAINT [PK_Member] PRIMARY KEY CLUSTERED
    (
        [MemberSeq] ASC
    )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
    ) ON [PRIMARY]
  END

-- IF NOT EXISTS(SELECT *
--               FROM INFORMATION_SCHEMA.TABLES
--               WHERE TABLE_NAME = 'Role')
-- BEGIN
--     CREATE TABLE [dbo].[Role](
--         [RoleSeq] [int] IDENTITY(1,1) NOT NULL,
--         [Name] [nvarchar](10) NULL,
--      CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED
--     (
--         [RoleSeq] ASC
--     )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
--     ) ON [PRIMARY]
-- END

IF NOT EXISTS(SELECT *
              FROM INFORMATION_SCHEMA.TABLES
              WHERE TABLE_NAME = 'Account')
BEGIN
CREATE TABLE [dbo].[Account](
    [AccountSeq] [int] IDENTITY(1,1) NOT NULL,
    [email] [nvarchar](100) NULL,
    [password] [nvarchar](100) NULL,
    [role] int NOT NULL,
    [MemberSeq] int NOT NULL,
    CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED
(
[AccountSeq] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
    ) ON [PRIMARY]
END


-- INSERT INTO Member VALUES ( 'sample@gmail.com', 'qwer1234', 'hong', 20, 1, 'seoul ... address ', GETDATE(), 0 );
-- INSERT INTO Account VALUES ( 'sample@gmail.com', 'qwer1234', 1, 1);


IF NOT EXISTS(SELECT *
              FROM INFORMATION_SCHEMA.TABLES
              WHERE TABLE_NAME = 'HouseInfo')
BEGIN
CREATE TABLE [dbo].[HouseInfo](
    [houseInfoSeq] [int] IDENTITY(1,1) NOT NULL,
    [address] [nvarchar](100) NULL,
    [place] [nvarchar](100) NULL,
    [price] int NULL,
    [room] int NULL,
    [floor] int NULL,
    [writeDT] [datetime] NULL,
    [regDT] [datetime] NULL,
    [delYN] [bit] NOT NULL,
    CONSTRAINT [PK_HouseInfo] PRIMARY KEY CLUSTERED
(
[houseInfoSeq] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
    ) ON [PRIMARY]
END