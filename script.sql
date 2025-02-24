USE [master]
GO
/****** Object:  Database [Taskify]    Script Date: 12/2/2023 6:43:44 PM ******/
CREATE DATABASE [Taskify]
 CONTAINMENT = NONE
 ON  PRIMARY
( NAME = N'Taskify', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Taskify.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON
( NAME = N'Taskify_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Taskify_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Taskify] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Taskify].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Taskify] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [Taskify] SET ANSI_NULLS OFF
GO
ALTER DATABASE [Taskify] SET ANSI_PADDING OFF
GO
ALTER DATABASE [Taskify] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [Taskify] SET ARITHABORT OFF
GO
ALTER DATABASE [Taskify] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [Taskify] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [Taskify] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [Taskify] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [Taskify] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [Taskify] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [Taskify] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [Taskify] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [Taskify] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [Taskify] SET  ENABLE_BROKER
GO
ALTER DATABASE [Taskify] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [Taskify] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [Taskify] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [Taskify] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [Taskify] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [Taskify] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [Taskify] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [Taskify] SET RECOVERY FULL
GO
ALTER DATABASE [Taskify] SET  MULTI_USER
GO
ALTER DATABASE [Taskify] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [Taskify] SET DB_CHAINING OFF
GO
ALTER DATABASE [Taskify] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF )
GO
ALTER DATABASE [Taskify] SET TARGET_RECOVERY_TIME = 60 SECONDS
GO
ALTER DATABASE [Taskify] SET DELAYED_DURABILITY = DISABLED
GO
ALTER DATABASE [Taskify] SET ACCELERATED_DATABASE_RECOVERY = OFF
GO
ALTER DATABASE [Taskify] SET QUERY_STORE = ON
GO
ALTER DATABASE [Taskify] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [Taskify]
GO
USE [Taskify]
GO
/****** Object:  Sequence [dbo].[class_seq]    Script Date: 12/20/2023 3:33:52 PM ******/
CREATE SEQUENCE [dbo].[class_seq]
    AS [bigint]
    START WITH 1
    INCREMENT BY 50
    MINVALUE -9223372036854775808
    MAXVALUE 9223372036854775807
    CACHE
    GO
    USE [Taskify]
    GO
/****** Object:  Sequence [dbo].[feature_seq]    Script Date: 12/20/2023 3:33:52 PM ******/
CREATE SEQUENCE [dbo].[feature_seq]
    AS [bigint]
    START WITH 1
    INCREMENT BY 50
    MINVALUE -9223372036854775808
    MAXVALUE 9223372036854775807
    CACHE
    GO
    USE [Taskify]
    GO
/****** Object:  Sequence [dbo].[groups_seq]    Script Date: 12/20/2023 3:33:52 PM ******/
CREATE SEQUENCE [dbo].[groups_seq]
    AS [bigint]
    START WITH 1
    INCREMENT BY 50
    MINVALUE -9223372036854775808
    MAXVALUE 9223372036854775807
    CACHE
    GO
    USE [Taskify]
    GO
/****** Object:  Sequence [dbo].[lecturer_seq]    Script Date: 12/20/2023 3:33:52 PM ******/
CREATE SEQUENCE [dbo].[lecturer_seq]
    AS [bigint]
    START WITH 1
    INCREMENT BY 50
    MINVALUE -9223372036854775808
    MAXVALUE 9223372036854775807
    CACHE
    GO
    USE [Taskify]
    GO
/****** Object:  Sequence [dbo].[messages_seq]    Script Date: 12/20/2023 3:33:52 PM ******/
CREATE SEQUENCE [dbo].[messages_seq]
    AS [bigint]
    START WITH 1
    INCREMENT BY 50
    MINVALUE -9223372036854775808
    MAXVALUE 9223372036854775807
    CACHE
    GO
    USE [Taskify]
    GO
/****** Object:  Sequence [dbo].[project_seq]    Script Date: 12/20/2023 3:33:52 PM ******/
CREATE SEQUENCE [dbo].[project_seq]
    AS [bigint]
    START WITH 1
    INCREMENT BY 50
    MINVALUE -9223372036854775808
    MAXVALUE 9223372036854775807
    CACHE
    GO
    USE [Taskify]
    GO
/****** Object:  Sequence [dbo].[semester_seq]    Script Date: 12/20/2023 3:33:52 PM ******/
CREATE SEQUENCE [dbo].[semester_seq]
    AS [bigint]
    START WITH 1
    INCREMENT BY 50
    MINVALUE -9223372036854775808
    MAXVALUE 9223372036854775807
    CACHE
    GO
    USE [Taskify]
    GO
/****** Object:  Sequence [dbo].[sprint_seq]    Script Date: 12/20/2023 3:33:52 PM ******/
CREATE SEQUENCE [dbo].[sprint_seq]
    AS [bigint]
    START WITH 1
    INCREMENT BY 50
    MINVALUE -9223372036854775808
    MAXVALUE 9223372036854775807
    CACHE
    GO
    USE [Taskify]
    GO
/****** Object:  Sequence [dbo].[star_seq]    Script Date: 12/20/2023 3:33:52 PM ******/
CREATE SEQUENCE [dbo].[star_seq]
    AS [bigint]
    START WITH 1
    INCREMENT BY 50
    MINVALUE -9223372036854775808
    MAXVALUE 9223372036854775807
    CACHE
    GO
    USE [Taskify]
    GO
/****** Object:  Sequence [dbo].[student_seq]    Script Date: 12/20/2023 3:33:52 PM ******/
CREATE SEQUENCE [dbo].[student_seq]
    AS [bigint]
    START WITH 1
    INCREMENT BY 50
    MINVALUE -9223372036854775808
    MAXVALUE 9223372036854775807
    CACHE
    GO
    USE [Taskify]
    GO
/****** Object:  Sequence [dbo].[task_seq]    Script Date: 12/20/2023 3:33:52 PM ******/
CREATE SEQUENCE [dbo].[task_seq]
    AS [bigint]
    START WITH 1
    INCREMENT BY 50
    MINVALUE -9223372036854775808
    MAXVALUE 9223372036854775807
    CACHE
    GO
    USE [Taskify]
    GO
/****** Object:  Sequence [dbo].[token_seq]    Script Date: 12/20/2023 3:33:52 PM ******/
CREATE SEQUENCE [dbo].[token_seq]
    AS [bigint]
    START WITH 1
    INCREMENT BY 50
    MINVALUE -9223372036854775808
    MAXVALUE 9223372036854775807
    CACHE
    GO
/****** Object:  Table [dbo].[class]    Script Date: 12/20/2023 3:33:52 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[class](
    [class_id] [int] NOT NULL,
    [class_name] [varchar](50) NULL,
    [status] [bit] NULL,
    [lecturer_id] [int] NULL,
    [semester_id] [int] NULL,
    PRIMARY KEY CLUSTERED
(
[class_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[feature]    Script Date: 12/20/2023 3:33:52 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[feature](
    [feature_id] [int] NOT NULL,
    [description] [nvarchar](100) NULL,
    [feature_name] [nvarchar](100) NULL,
    CONSTRAINT [PK__feature__7906CBD7EF29DACE] PRIMARY KEY CLUSTERED
(
[feature_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[groups]    Script Date: 12/20/2023 3:33:52 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[groups](
    [group_id] [int] NOT NULL,
    [group_name] [varchar](50) NULL,
    [score] [real] NULL,
    [status] [bit] NULL,
    [class_id] [int] NULL,
    [project_id] [int] NULL,
    PRIMARY KEY CLUSTERED
(
[group_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[lecturer]    Script Date: 12/20/2023 3:33:52 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[lecturer](
    [lecturer_id] [int] NOT NULL,
    [email] [varchar](50) NULL,
    [lecturer_name] [nvarchar](50) NULL,
    [picture] [varchar](max) NOT NULL,
    [status] [bit] NULL,
    CONSTRAINT [PK__lecturer__D4D1DAB15CC741E2] PRIMARY KEY CLUSTERED
(
[lecturer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[messages]    Script Date: 12/20/2023 3:33:52 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[messages](
    [message_id] [int] NOT NULL,
    [change_status_time] [datetime2](6) NULL,
    [create_note] [varchar](max) NULL,
    [request_note] [nvarchar](50) NULL,
    [respone_note] [nvarchar](50) NULL,
    [status] [varchar](50) NULL,
    [type] [varchar](50) NULL,
    [group_id] [int] NULL,
    [lecturer_id] [int] NULL,
    CONSTRAINT [PK__messages__0BBF6EE6176F608E] PRIMARY KEY CLUSTERED
(
[message_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[process]    Script Date: 12/20/2023 3:33:52 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[process](
    [feature] [int] NOT NULL,
    [project] [int] NOT NULL,
    [sprint] [int] NOT NULL,
    [feature_id] [int] NULL,
    [project_id] [int] NULL,
    [sprint_id] [int] NULL,
     PRIMARY KEY CLUSTERED
    (
    [feature] ASC,
    [project] ASC,
[sprint] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[project]    Script Date: 12/20/2023 3:33:52 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[project](
    [project_id] [int] NOT NULL,
    [context] [varchar](max) NOT NULL,
    [functional_requirements] [varchar](max) NOT NULL,
    [non_functional_requirements] [varchar](max) NOT NULL,
    [problems] [varchar](max) NOT NULL,
    [project_name] [varchar](50) NULL,
    [status] [varchar](100) NULL,
    [lecturer_id] [int] NULL,
    [deleted] [bit] NULL,
    PRIMARY KEY CLUSTERED
(
[project_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[semester]    Script Date: 12/20/2023 3:33:52 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[semester](
    [semester_id] [int] NOT NULL,
    [end_date] [datetime2](6) NULL,
    [semester_name] [varchar](50) NULL,
    [start_date] [datetime2](6) NULL,
    [status] [bit] NULL,
    PRIMARY KEY CLUSTERED
(
[semester_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[sprint]    Script Date: 12/20/2023 3:33:52 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[sprint](
    [sprint_id] [int] NOT NULL,
    [end_date] [datetime2](6) NULL,
    [feedback] [varchar](100) NULL,
    [sprint_name] [varchar](50) NULL,
    [start_date] [datetime2](6) NULL,
    [status] [varchar](100) NULL,
    [deleted] [bit] NULL,
    PRIMARY KEY CLUSTERED
(
[sprint_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[star]    Script Date: 12/20/2023 3:33:52 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[star](
    [star_id] [int] NOT NULL,
    [change_status_time] [datetime2](6) NULL,
    [good_knowledge] [real] NULL,
    [hard_working] [real] NULL,
    [response_note] [varchar](100) NULL,
    [status] [bit] NULL,
    [team_working] [real] NULL,
    [total] [real] NULL,
    [sprint_id] [int] NULL,
    [student_id] [int] NULL,
    PRIMARY KEY CLUSTERED
(
[star_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[student]    Script Date: 12/20/2023 3:33:52 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[student](
    [student_id] [int] NOT NULL,
    [about] [varchar](200) NULL,
    [email] [varchar](200) NULL,
    [github] [varchar](200) NULL,
    [is_leader] [bit] NULL,
    [link_facebook] [varchar](200) NULL,
    [password] [varchar](max) NULL,
    [pending] [varbinary](255) NULL,
    [picture] [varchar](max) NULL,
    [score] [real] NULL,
    [skills] [varchar](200) NULL,
    [status] [varchar](255) NULL,
    [student_name] [nvarchar](50) NULL,
    [class_id] [int] NULL,
    [group_id] [int] NULL,
    CONSTRAINT [PK__student__2A33069A357EE0C5] PRIMARY KEY CLUSTERED
(
[student_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[student_task]    Script Date: 12/20/2023 3:33:52 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[student_task](
    [student] [int] NOT NULL,
    [task] [int] NOT NULL,
    [student_id] [int] NULL,
    [task_id] [int] NULL,
     PRIMARY KEY CLUSTERED
    (
    [student] ASC,
[task] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[task]    Script Date: 12/20/2023 3:33:52 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[task](
    [task_id] [int] NOT NULL,
    [description] [nvarchar](200) NULL,
    [feedback] [nvarchar](50) NULL,
    [priority] [varchar](50) NULL,
    [status] [varchar](100) NULL,
    [task_name] [nvarchar](50) NULL,
    [feature_id] [int] NULL,
    CONSTRAINT [PK__task__0492148DCB19E658] PRIMARY KEY CLUSTERED
(
[task_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[token]    Script Date: 12/20/2023 3:33:52 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[token](
    [id] [int] NOT NULL,
    [expired] [bit] NOT NULL,
    [revoke] [bit] NULL,
    [token] [varchar](255) NULL,
    [token_type] [varchar](255) NULL,
    [student_id] [int] NULL,
    PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
    INSERT [dbo].[class] ([class_id], [class_name], [status], [lecturer_id], [semester_id]) VALUES (1, N'12A8', 0, NULL, NULL)
    INSERT [dbo].[class] ([class_id], [class_name], [status], [lecturer_id], [semester_id]) VALUES (2, N'9.12', 0, NULL, NULL)
    INSERT [dbo].[class] ([class_id], [class_name], [status], [lecturer_id], [semester_id]) VALUES (3, N'PRJ391', 1, 1, 1)
    INSERT [dbo].[class] ([class_id], [class_name], [status], [lecturer_id], [semester_id]) VALUES (4, N'LAB211', 1, 1, 1)
    INSERT [dbo].[class] ([class_id], [class_name], [status], [lecturer_id], [semester_id]) VALUES (5, N'JPD101', 1, 2, 1)
    GO
    INSERT [dbo].[feature] ([feature_id], [description], [feature_name]) VALUES (1, N'Your future depends on what you do today', N'Feature 1')
    INSERT [dbo].[feature] ([feature_id], [description], [feature_name]) VALUES (2, N'Your future depends on what you do today', N'Feature 2')
    GO
    INSERT [dbo].[groups] ([group_id], [group_name], [score], [status], [class_id], [project_id]) VALUES (1, N'Group 1', 4.2, 1, 1, 1)
    INSERT [dbo].[groups] ([group_id], [group_name], [score], [status], [class_id], [project_id]) VALUES (2, N'Group 2', 8, 1, 3, 2)
    GO
    INSERT [dbo].[lecturer] ([lecturer_id], [email], [lecturer_name], [picture], [status]) VALUES (1, N'nguyenthehoang@gmail.com', N'Nguyễn Thế Hoàng', N'https://scontent.fsgn2-7.fna.fbcdn.net/v/t39.30808-6/270961679_10159870536636108_2642967668131478092_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=efb6e6&_nc_ohc=W2gY1CWNpD4AX8X-zbq&_nc_oc=AQnYo9iDDmgzAcD3tRoXbcRrOFT9VuX6_Y_DrVrHcnSuc7SAdwHqLRT2dBcRZghx0ZkxnPF2knAfVINofbkLWo4P&_nc_ht=scontent.fsgn2-7.fna&oh=00_AfB7mZV1D3jaUPLkVfQ3gt72FXYUdoYEgAtIylGRzFtAdg&oe=65727257', 1)
    INSERT [dbo].[lecturer] ([lecturer_id], [email], [lecturer_name], [picture], [status]) VALUES (2, N'nguyenvana@gmail.com', N'Thân Văn Sử', N'https://scontent.fsgn2-7.fna.fbcdn.net/v/t39.30808-6/270961679_10159870536636108_2642967668131478092_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=efb6e6&_nc_ohc=W2gY1CWNpD4AX8X-zbq&_nc_oc=AQnYo9iDDmgzAcD3tRoXbcRrOFT9VuX6_Y_DrVrHcnSuc7SAdwHqLRT2dBcRZghx0ZkxnPF2knAfVINofbkLWo4P&_nc_ht=scontent.fsgn2-7.fna&oh=00_AfB7mZV1D3jaUPLkVfQ3gt72FXYUdoYEgAtIylGRzFtAdg&oe=65727257', 1)
    INSERT [dbo].[lecturer] ([lecturer_id], [email], [lecturer_name], [picture], [status]) VALUES (3, N'huynhvanb@gmail.com', N'Hồ Hoàn Kiếm', N'https://scontent.fsgn2-7.fna.fbcdn.net/v/t39.30808-6/270961679_10159870536636108_2642967668131478092_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=efb6e6&_nc_ohc=W2gY1CWNpD4AX8X-zbq&_nc_oc=AQnYo9iDDmgzAcD3tRoXbcRrOFT9VuX6_Y_DrVrHcnSuc7SAdwHqLRT2dBcRZghx0ZkxnPF2knAfVINofbkLWo4P&_nc_ht=scontent.fsgn2-7.fna&oh=00_AfB7mZV1D3jaUPLkVfQ3gt72FXYUdoYEgAtIylGRzFtAdg&oe=65727257', 1)
    GO
    INSERT [dbo].[process] ([feature], [project], [sprint], [feature_id], [project_id], [sprint_id]) VALUES (1, 1, 1, 1, 1, 1)
    INSERT [dbo].[process] ([feature], [project], [sprint], [feature_id], [project_id], [sprint_id]) VALUES (1, 1, 2, 1, 1, 2)
    INSERT [dbo].[process] ([feature], [project], [sprint], [feature_id], [project_id], [sprint_id]) VALUES (2, 1, 2, 2, 1, 2)
    GO
    INSERT [dbo].[project] ([project_id], [context], [functional_requirements], [non_functional_requirements], [problems], [project_name], [status], [lecturer_id], [deleted]) VALUES (1, N'The atomic boom', N'The explosion need to be 250ft tall', N'Destroy everything', N'no problem', N'Manhattan', N'1', NULL, 0)
    INSERT [dbo].[project] ([project_id], [context], [functional_requirements], [non_functional_requirements], [problems], [project_name], [status], [lecturer_id], [deleted]) VALUES (2, N'Help manage task', N'Able to settle things', N'high performance', N'no problem', N'Taskify', N'1', NULL, 0)
    INSERT [dbo].[project] ([project_id], [context], [functional_requirements], [non_functional_requirements], [problems], [project_name], [status], [lecturer_id], [deleted]) VALUES (3, N'AweSome Job', N'Software Engineering', N'high performance', N'no problems', N'Wishes', N'1', NULL, 0)
    GO
    INSERT [dbo].[semester] ([semester_id], [end_date], [semester_name], [start_date], [status]) VALUES (1, CAST(N'2023-09-01T00:00:00.0000000' AS DateTime2), N'Fall 2023', CAST(N'2023-11-30T00:00:00.0000000' AS DateTime2), 1)
    INSERT [dbo].[semester] ([semester_id], [end_date], [semester_name], [start_date], [status]) VALUES (2, CAST(N'2024-01-01T00:00:00.0000000' AS DateTime2), N'Spring 2024', CAST(N'2024-03-30T00:00:00.0000000' AS DateTime2), 1)
    GO
    INSERT [dbo].[sprint] ([sprint_id], [end_date], [feedback], [sprint_name], [start_date], [status], [deleted]) VALUES (1, CAST(N'2023-12-17T00:00:00.0000000' AS DateTime2), N'Well done!', N'Sprint number 1', NULL, N'Miss Deadline', 0)
    INSERT [dbo].[sprint] ([sprint_id], [end_date], [feedback], [sprint_name], [start_date], [status], [deleted]) VALUES (2, CAST(N'2023-12-17T00:00:00.0000000' AS DateTime2), N'Well done!', N'Sprint number 2', NULL, N'Miss Deadline', 0)
    GO
    INSERT [dbo].[star] ([star_id], [change_status_time], [good_knowledge], [hard_working], [response_note], [status], [team_working], [total], [sprint_id], [student_id]) VALUES (1, CAST(N'2023-12-17T13:45:55.1880000' AS DateTime2), 4.8, 4.5, N'Great teamwork!', 1, 4.2, 12.5, 1, 1)
    GO
    INSERT [dbo].[student] ([student_id], [about], [email], [github], [is_leader], [link_facebook], [password], [pending], [picture], [score], [skills], [status], [student_name], [class_id], [group_id]) VALUES (1, N'A passionate web developer from VietNam.', N'abc1@gmail.com', N'https://github.com/RankillerDY', 0, N'https://www.facebook.com/hau.chu.334/', N'$2a$10$ENZ.xReukWEHHEWd29Ox5eDiw9vtfOxztc1XWrvtAz3C.Tgr7LH92', NULL, N'https://avatars.githubusercontent.com/u/66985115?s=400&u=d23c5b8f3934e1e7fd0c7b61f9cd16b94a51f071&v=4', 3.2, N'Front-end React, Angular. Back-end NodeJS, Java Servlet & JSP', NULL, N'Nguyễn Văn A', 1, 1)
    INSERT [dbo].[student] ([student_id], [about], [email], [github], [is_leader], [link_facebook], [password], [pending], [picture], [score], [skills], [status], [student_name], [class_id], [group_id]) VALUES (2, N'A passionate web developer from VietNam.', N'abc2@gmail.com', N'https://github.com/RankillerDY', 1, N'https://www.facebook.com/hau.chu.334/', N'$2a$10$ENZ.xReukWEHHEWd29Ox5eDiw9vtfOxztc1XWrvtAz3C.Tgr7LH92', NULL, N'https://avatars.githubusercontent.com/u/66985115?s=400&u=d23c5b8f3934e1e7fd0c7b61f9cd16b94a51f071&v=4', 3.2, N'Front-end React, Angular. Back-end NodeJS, Java Servlet & JSP', NULL, N'Huỳnh Văn B', 2, 2)
    INSERT [dbo].[student] ([student_id], [about], [email], [github], [is_leader], [link_facebook], [password], [pending], [picture], [score], [skills], [status], [student_name], [class_id], [group_id]) VALUES (3, N'A passionate web developer from VietNam.', N'nguyenhuykhaipch94@gmail.com', N'https://github.com/nguyenhuykhai', 0, N'https://www.facebook.com/huykhai.Pi/', N'$2a$10$ENZ.xReukWEHHEWd29Ox5eDiw9vtfOxztc1XWrvtAz3C.Tgr7LH92', NULL, N'https://avatars.githubusercontent.com/u/66985115?s=400&u=d23c5b8f3934e1e7fd0c7b61f9cd16b94a51f071&v=4', 8, N'Front-end React, Angular. Back-end NodeJS, Java Servlet & JSP', NULL, N'Nguyễn Huy Khải', 1, 1)
    INSERT [dbo].[student] ([student_id], [about], [email], [github], [is_leader], [link_facebook], [password], [pending], [picture], [score], [skills], [status], [student_name], [class_id], [group_id]) VALUES (4, N'A passionate web developer from VietNam.', N'hieutv@gmail.com', N'https://github.com/hieutv', 0, N'https://www.facebook.com/hau.chu.334/', N'$2a$10$ENZ.xReukWEHHEWd29Ox5eDiw9vtfOxztc1XWrvtAz3C.Tgr7LH92', NULL, N'https://scontent.fsgn2-8.fna.fbcdn.net/v/t39.30808-6/342764149_1890690684599722_1129199332142690555_n.jpg?_nc_cat=1&ccb=1-7&_nc_sid=efb6e6&_nc_ohc=dWUgWL2KRf4AX_ss_ij&_nc_ht=scontent.fsgn2-8.fna&oh=00_AfBhMmznGqPRb8v1jZkfoUSEzMC3x3rRPAjvgoFXxNIQ4Q&oe=65739221', 7, N'Front-end React, Angular, VueJS.', NULL, N'Hiếu TV', 1, 1)
    INSERT [dbo].[student] ([student_id], [about], [email], [github], [is_leader], [link_facebook], [password], [pending], [picture], [score], [skills], [status], [student_name], [class_id], [group_id]) VALUES (5, N'A passionate web developer from VietNam.', N'dinhgiabao@gmail.com', N'https://github.com/RankillerDY', 1, N'https://www.facebook.com/media/set/?set=a.1556724354582064&type=3', N'$2a$10$ENZ.xReukWEHHEWd29Ox5eDiw9vtfOxztc1XWrvtAz3C.Tgr7LH92', NULL, N'https://scontent.fsgn2-9.fna.fbcdn.net/v/t39.30808-1/344363561_1269430363660340_8170588377395495271_n.jpg?stp=dst-jpg_p200x200&_nc_cat=106&ccb=1-7&_nc_sid=5740b7&_nc_ohc=7xlvsTYKP1gAX_G3zVI&_nc_ht=scontent.fsgn2-9.fna&oh=00_AfBtqR0MSV-TnVcXeddd8Wdq6eUg5IwT_b0ibbAXPVS1lg&oe=6572B33A', 7.5, N'Front-end React. Back-end With Java and Spring Boot', NULL, N'Đinh Gia Bảo', 1, 1)
    INSERT [dbo].[student] ([student_id], [about], [email], [github], [is_leader], [link_facebook], [password], [pending], [picture], [score], [skills], [status], [student_name], [class_id], [group_id]) VALUES (6, N'A passionate web developer from VietNam.', N'nguyenthanhdat@gmail.com', N'https://github.com/datntse150392', 0, N'https://www.facebook.com/ngdat2001', N'$2a$10$ENZ.xReukWEHHEWd29Ox5eDiw9vtfOxztc1XWrvtAz3C.Tgr7LH92', NULL, N'https://scontent.fsgn5-5.fna.fbcdn.net/v/t39.30808-1/383156738_876433974066903_9157601909979294358_n.jpg?stp=dst-jpg_p200x200&_nc_cat=100&ccb=1-7&_nc_sid=5740b7&_nc_ohc=Kh0cx2e8tWUAX8rkjGW&_nc_ht=scontent.fsgn5-5.fna&oh=00_AfDrjeZau6V9Ksfkw-UeUCysCqJ2YXc3oA7RCWcvLFdteA&oe=657466E1', 9, N'Programming Language: C, C++, Java, JavaScript, TypeScript. Front-end: Angular, Tailwind,...', NULL, N'Nguyễn Thành Đạt', 1, 1)
    INSERT [dbo].[student] ([student_id], [about], [email], [github], [is_leader], [link_facebook], [password], [pending], [picture], [score], [skills], [status], [student_name], [class_id], [group_id]) VALUES (7, N'Everything has a price - Keep motivated', N'buiductri@gmail.com', N'https://www.facebook.com/tribdsie2k2', 0, N'https://www.facebook.com/tribdsie2k2', N'$2a$10$ENZ.xReukWEHHEWd29Ox5eDiw9vtfOxztc1XWrvtAz3C.Tgr7LH92', NULL, N'https://avatars.githubusercontent.com/u/99896326?v=4', 7, N'Programming Language: C, C++, Java, JavaScript, TypeScript. Front-end: Angular, Tailwind,...', NULL, N'Bùi Đức Trí', 1, 1)
    INSERT [dbo].[student] ([student_id], [about], [email], [github], [is_leader], [link_facebook], [password], [pending], [picture], [score], [skills], [status], [student_name], [class_id], [group_id]) VALUES (8, N'A passionate web developer from VietNam.', N'buinguyenkimlong@gmail.com', N'https://github.com/Logbui', 0, N'https://www.facebook.com/joshua.logb', N'$2a$10$ENZ.xReukWEHHEWd29Ox5eDiw9vtfOxztc1XWrvtAz3C.Tgr7LH92', NULL, N'https://avatars.githubusercontent.com/u/112839830?v=4', 8, N'Front-end React. Back-end With Java and Spring Boot', NULL, N'Bùi Nguyên Kim Long', 1, 1)
    INSERT [dbo].[student] ([student_id], [about], [email], [github], [is_leader], [link_facebook], [password], [pending], [picture], [score], [skills], [status], [student_name], [class_id], [group_id]) VALUES (9, N'A passionate web developer from VietNam.', N'duongkha@gmail.com', N'https://github.com/duongkha', 0, N'https://www.facebook.com/Kha.Writer', N'$2a$10$ENZ.xReukWEHHEWd29Ox5eDiw9vtfOxztc1XWrvtAz3C.Tgr7LH92', NULL, N'https://scontent.fsgn5-9.fna.fbcdn.net/v/t39.30808-1/338907404_958055142202200_8468921168827551143_n.jpg?stp=cp6_dst-jpg_p200x200&_nc_cat=102&ccb=1-7&_nc_sid=5740b7&_nc_ohc=rjU_meKPO3IAX-L3JKT&_nc_ht=scontent.fsgn5-9.fna&oh=00_AfD3EqEY_fNEkfpHN3vY_EZOQ7wdWJ4Wg2adzgk3PH4feQ&oe=65762DF9', 6, N'Front-end React, Angular. Back-end NodeJS, Java Servlet & JSP', NULL, N'Dương Kha', 2, 1)
    INSERT [dbo].[student] ([student_id], [about], [email], [github], [is_leader], [link_facebook], [password], [pending], [picture], [score], [skills], [status], [student_name], [class_id], [group_id]) VALUES (10, N'A passionate web developer from VietNam.', N'nguyenthang@gmail.com', N'https://github.com/nguyenthang', 0, N'https://www.facebook.com/profile.php?id=100008469910934', N'$2a$10$ENZ.xReukWEHHEWd29Ox5eDiw9vtfOxztc1XWrvtAz3C.Tgr7LH92', NULL, N'https://scontent.fsgn5-14.fna.fbcdn.net/v/t1.6435-9/194179724_2657780404514264_4066957038300885500_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=7a1959&_nc_ohc=i50QICqqeSgAX9XfAa3&_nc_ht=scontent.fsgn5-14.fna&oh=00_AfBjcLqPCqLVe3f4vi3PCIybeT_qE-zynPq3lQQo0hL7Zw&oe=6597D1E7', 8, N'Front-end React, Angular, VueJS.', NULL, N'Thắng Nguyễn', 2, 2)
    INSERT [dbo].[student] ([student_id], [about], [email], [github], [is_leader], [link_facebook], [password], [pending], [picture], [score], [skills], [status], [student_name], [class_id], [group_id]) VALUES (11, N'A passionate web developer from VietNam.', N'phamphungoctrai@gmail.com', N'https://github.com/phamphungoctrai', 0, N'https://www.facebook.com/jayllFA', N'$2a$10$ENZ.xReukWEHHEWd29Ox5eDiw9vtfOxztc1XWrvtAz3C.Tgr7LH92', NULL, N'https://scontent.fsgn5-9.fna.fbcdn.net/v/t39.30808-1/398559178_1096293964691433_4851128006500678997_n.jpg?stp=dst-jpg_p200x200&_nc_cat=102&ccb=1-7&_nc_sid=5740b7&_nc_ohc=WJONvqon81UAX_N5khC&_nc_ht=scontent.fsgn5-9.fna&oh=00_AfC0cOV4tA8tR7xrx0Ejmul64x_h4c3ZzObIZ6tu5-dtZg&oe=6574B3EB', 7, N'Front-end React. Back-end With Java and Spring Boot', NULL, N'Phạm Phú Ngọc Trai', 2, 2)
    INSERT [dbo].[student] ([student_id], [about], [email], [github], [is_leader], [link_facebook], [password], [pending], [picture], [score], [skills], [status], [student_name], [class_id], [group_id]) VALUES (12, N'A passionate web developer from VietNam.', N'sondang@gmail.com', N'https://github.com/sondang', 0, N'https://www.facebook.com/sondnf8', N'$2a$10$ENZ.xReukWEHHEWd29Ox5eDiw9vtfOxztc1XWrvtAz3C.Tgr7LH92', NULL, N'https://scontent.fsgn5-11.fna.fbcdn.net/v/t39.30808-6/250951029_2310653682405428_2097463697023468442_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=efb6e6&_nc_ohc=xUKCgVj-WaIAX_QhiWC&_nc_ht=scontent.fsgn5-11.fna&oh=00_AfDXLBwrnY5tXAzsGSsQOCN1MW8637Az65jU4F89YfeFZQ&oe=657583D6', 7.5, N'Programming Language: C, C++, Java, JavaScript, TypeScript. Front-end: Angular, Tailwind,...', NULL, N'Sơn Đặng', 2, 2)
    INSERT [dbo].[student] ([student_id], [about], [email], [github], [is_leader], [link_facebook], [password], [pending], [picture], [score], [skills], [status], [student_name], [class_id], [group_id]) VALUES (13, N'Everything has a price - Keep motivated', N'ongdevvuitinh@gmail.com', N'https://github.com/ongdevvuitinh', 0, N'https://www.facebook.com/ongdevvuitinh', N'$2a$10$ENZ.xReukWEHHEWd29Ox5eDiw9vtfOxztc1XWrvtAz3C.Tgr7LH92', NULL, N'https://scontent.fsgn5-10.fna.fbcdn.net/v/t39.30808-6/273462773_351272957001508_2440165503586301331_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=efb6e6&_nc_ohc=4CIyhWBASVAAX85WYgu&_nc_ht=scontent.fsgn5-10.fna&oh=00_AfCUBPFJ7yXbGu7ml1ChHULbzEz82zysBcegZNTKqu5byw&oe=657592A5', 8.5, N'Programming Language: C, C++, Java, JavaScript, TypeScript. Front-end: Angular, Tailwind,...', NULL, N'Ông dev vui tính', 2, 2)
    INSERT [dbo].[student] ([student_id], [about], [email], [github], [is_leader], [link_facebook], [password], [pending], [picture], [score], [skills], [status], [student_name], [class_id], [group_id]) VALUES (14, N'A passionate web developer from VietNam.', N'luffy@gmail.com', N'https://github.com/luffy', 0, N'https://www.facebook.com/profile.php?id=100075849699479', N'$2a$10$ENZ.xReukWEHHEWd29Ox5eDiw9vtfOxztc1XWrvtAz3C.Tgr7LH92', NULL, N'https://scontent.fsgn5-12.fna.fbcdn.net/v/t39.30808-6/278731452_144039178134405_7949597945527904443_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=efb6e6&_nc_ohc=mDIPM5BZufMAX_c6dxX&_nc_ht=scontent.fsgn5-12.fna&oh=00_AfAweQm4-xhRT6aZ1D-F70paC6BxJyaCLtnKWqGC3LbcXA&oe=65752DAF', 9, N'Front-end React. Back-end With Java and Spring Boot', NULL, N'Luffy Mũ Rơm', 2, 2)
    GO
    INSERT [dbo].[student_task] ([student], [task], [student_id], [task_id]) VALUES (1, 1, 1, 1)
    INSERT [dbo].[student_task] ([student], [task], [student_id], [task_id]) VALUES (1, 3, 1, 3)
    INSERT [dbo].[student_task] ([student], [task], [student_id], [task_id]) VALUES (2, 2, 2, 2)
    GO
    INSERT [dbo].[task] ([task_id], [description], [feedback], [priority], [status], [task_name], [feature_id]) VALUES (1, N'Your future depends on what you do today', N'Well done!', N'Top prior', N'Finished', N'Task 1', 1)
    INSERT [dbo].[task] ([task_id], [description], [feedback], [priority], [status], [task_name], [feature_id]) VALUES (2, N'Your future depends on what you do today', N'Well done!', N'Top prior', N'Miss Deadline', N'Task 2', 1)
    INSERT [dbo].[task] ([task_id], [description], [feedback], [priority], [status], [task_name], [feature_id]) VALUES (3, N'Your future depends on what you do today', N'Well done!', N'Top prior', N'Miss Deadline', N'Task 3', 1)
    GO
    INSERT [dbo].[token] ([id], [expired], [revoke], [token], [token_type], [student_id]) VALUES (1, 1, 1, N'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhYmMxQGdtYWlsLmNvbSIsImlhdCI6MTcwMjc4NzQwNSwiZXhwIjoxNzAyODczODA1fQ.dGSL-RnOtpbFw6xAz7awsxi9wzbGEUFLYy_7iGgY3-Y', N'BEARER', 1)
    INSERT [dbo].[token] ([id], [expired], [revoke], [token], [token_type], [student_id]) VALUES (2, 1, 1, N'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhYmMxQGdtYWlsLmNvbSIsImlhdCI6MTcwMjk4NTI1NywiZXhwIjoxNzAzMDcxNjU3fQ.91Qn6ptwWyF5xVUMB1gL76y5CPBWO874S5HdGNbEG3A', N'BEARER', 1)
    INSERT [dbo].[token] ([id], [expired], [revoke], [token], [token_type], [student_id]) VALUES (3, 1, 1, N'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhYmMxQGdtYWlsLmNvbSIsImlhdCI6MTcwMjk4NTI2OCwiZXhwIjoxNzAzMDcxNjY4fQ.q_AmNmwqSo7fT1gTiL08SF4yPzm2UFgTl4wa0D6tAeA', N'BEARER', 1)
    INSERT [dbo].[token] ([id], [expired], [revoke], [token], [token_type], [student_id]) VALUES (52, 0, 0, N'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhYmMxQGdtYWlsLmNvbSIsImlhdCI6MTcwMzA2MTEyOCwiZXhwIjoxNzAzMTQ3NTI4fQ.JwMgXaBy5BnrDk2y5-i_k2P8L89T0Y8eZH0EBbx4y-0', N'BEARER', 1)
    GO
ALTER TABLE [dbo].[class]  WITH CHECK ADD  CONSTRAINT [FK2on56akwlwj9yp1g7ko9bl7rq] FOREIGN KEY([semester_id])
    REFERENCES [dbo].[semester] ([semester_id])
    GO
ALTER TABLE [dbo].[class] CHECK CONSTRAINT [FK2on56akwlwj9yp1g7ko9bl7rq]
    GO
ALTER TABLE [dbo].[class]  WITH CHECK ADD  CONSTRAINT [FK7426kcgwh0nj767k9if4fmdq4] FOREIGN KEY([lecturer_id])
    REFERENCES [dbo].[lecturer] ([lecturer_id])
    GO
ALTER TABLE [dbo].[class] CHECK CONSTRAINT [FK7426kcgwh0nj767k9if4fmdq4]
    GO
ALTER TABLE [dbo].[groups]  WITH CHECK ADD  CONSTRAINT [FK9enhtwnuc1iya534oexiv8cld] FOREIGN KEY([class_id])
    REFERENCES [dbo].[class] ([class_id])
    GO
ALTER TABLE [dbo].[groups] CHECK CONSTRAINT [FK9enhtwnuc1iya534oexiv8cld]
    GO
ALTER TABLE [dbo].[groups]  WITH CHECK ADD  CONSTRAINT [FKnppr9twfbs3qybu6ot6ylatdl] FOREIGN KEY([project_id])
    REFERENCES [dbo].[project] ([project_id])
    GO
ALTER TABLE [dbo].[groups] CHECK CONSTRAINT [FKnppr9twfbs3qybu6ot6ylatdl]
    GO
ALTER TABLE [dbo].[messages]  WITH CHECK ADD  CONSTRAINT [FK2cpth2c6q2d75e9ppqyc402t] FOREIGN KEY([group_id])
    REFERENCES [dbo].[groups] ([group_id])
    GO
ALTER TABLE [dbo].[messages] CHECK CONSTRAINT [FK2cpth2c6q2d75e9ppqyc402t]
    GO
ALTER TABLE [dbo].[messages]  WITH CHECK ADD  CONSTRAINT [FK97ib10kvejk62dmfshhcq78u0] FOREIGN KEY([lecturer_id])
    REFERENCES [dbo].[lecturer] ([lecturer_id])
    GO
ALTER TABLE [dbo].[messages] CHECK CONSTRAINT [FK97ib10kvejk62dmfshhcq78u0]
    GO
ALTER TABLE [dbo].[process]  WITH CHECK ADD  CONSTRAINT [FKapeehunit1njtnheu53dfg39p] FOREIGN KEY([project_id])
    REFERENCES [dbo].[project] ([project_id])
    GO
ALTER TABLE [dbo].[process] CHECK CONSTRAINT [FKapeehunit1njtnheu53dfg39p]
    GO
ALTER TABLE [dbo].[process]  WITH CHECK ADD  CONSTRAINT [FKj21u5ygor07mgue8vfe4wfsf1] FOREIGN KEY([sprint_id])
    REFERENCES [dbo].[sprint] ([sprint_id])
    GO
ALTER TABLE [dbo].[process] CHECK CONSTRAINT [FKj21u5ygor07mgue8vfe4wfsf1]
    GO
ALTER TABLE [dbo].[process]  WITH CHECK ADD  CONSTRAINT [FKq1kqbg7rcsu5ao5tac93xs8x0] FOREIGN KEY([feature_id])
    REFERENCES [dbo].[feature] ([feature_id])
    GO
ALTER TABLE [dbo].[process] CHECK CONSTRAINT [FKq1kqbg7rcsu5ao5tac93xs8x0]
    GO
ALTER TABLE [dbo].[project]  WITH CHECK ADD  CONSTRAINT [FKsm959tfd2la9efi39dfg4w1fd] FOREIGN KEY([lecturer_id])
    REFERENCES [dbo].[lecturer] ([lecturer_id])
    GO
ALTER TABLE [dbo].[project] CHECK CONSTRAINT [FKsm959tfd2la9efi39dfg4w1fd]
    GO
ALTER TABLE [dbo].[star]  WITH CHECK ADD  CONSTRAINT [FKcc46k3fsnpqd9nsl88xdksq0k] FOREIGN KEY([student_id])
    REFERENCES [dbo].[student] ([student_id])
    GO
ALTER TABLE [dbo].[star] CHECK CONSTRAINT [FKcc46k3fsnpqd9nsl88xdksq0k]
    GO
ALTER TABLE [dbo].[star]  WITH CHECK ADD  CONSTRAINT [FKp10mvbibquef66yi6menpfdv7] FOREIGN KEY([sprint_id])
    REFERENCES [dbo].[sprint] ([sprint_id])
    GO
ALTER TABLE [dbo].[star] CHECK CONSTRAINT [FKp10mvbibquef66yi6menpfdv7]
    GO
ALTER TABLE [dbo].[student]  WITH CHECK ADD  CONSTRAINT [FKdwhkib64u47wc4yo4hk0cub90] FOREIGN KEY([class_id])
    REFERENCES [dbo].[class] ([class_id])
    GO
ALTER TABLE [dbo].[student] CHECK CONSTRAINT [FKdwhkib64u47wc4yo4hk0cub90]
    GO
ALTER TABLE [dbo].[student]  WITH CHECK ADD  CONSTRAINT [FKsflcrdigyrhbqi27vvioiw53q] FOREIGN KEY([group_id])
    REFERENCES [dbo].[groups] ([group_id])
    GO
ALTER TABLE [dbo].[student] CHECK CONSTRAINT [FKsflcrdigyrhbqi27vvioiw53q]
    GO
ALTER TABLE [dbo].[student_task]  WITH CHECK ADD  CONSTRAINT [FKiwgfy2a2f9dt0lo5uaed91qkt] FOREIGN KEY([student_id])
    REFERENCES [dbo].[student] ([student_id])
    GO
ALTER TABLE [dbo].[student_task] CHECK CONSTRAINT [FKiwgfy2a2f9dt0lo5uaed91qkt]
    GO
ALTER TABLE [dbo].[student_task]  WITH CHECK ADD  CONSTRAINT [FKkpecms0ad9qb4sylcdqvh7vs9] FOREIGN KEY([task_id])
    REFERENCES [dbo].[task] ([task_id])
    GO
ALTER TABLE [dbo].[student_task] CHECK CONSTRAINT [FKkpecms0ad9qb4sylcdqvh7vs9]
    GO
ALTER TABLE [dbo].[task]  WITH CHECK ADD  CONSTRAINT [FK7ckhntubrsu7adavawg5wi13t] FOREIGN KEY([feature_id])
    REFERENCES [dbo].[feature] ([feature_id])
    GO
ALTER TABLE [dbo].[task] CHECK CONSTRAINT [FK7ckhntubrsu7adavawg5wi13t]
    GO
ALTER TABLE [dbo].[token]  WITH CHECK ADD  CONSTRAINT [FK1j9myk0fjdutkio0tf3mne3u9] FOREIGN KEY([student_id])
    REFERENCES [dbo].[student] ([student_id])
    GO
ALTER TABLE [dbo].[token] CHECK CONSTRAINT [FK1j9myk0fjdutkio0tf3mne3u9]
    GO
ALTER TABLE [dbo].[token]  WITH CHECK ADD CHECK  (([token_type]='BEARER'))
    GO
    USE [master]
    GO
ALTER DATABASE [Taskify] SET  READ_WRITE
GO
