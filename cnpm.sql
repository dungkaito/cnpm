CREATE DATABASE  IF NOT EXISTS `cnpm` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cnpm`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: cnpm
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bai_da_luu`
--

DROP TABLE IF EXISTS `bai_da_luu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bai_da_luu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idThuePhong` int DEFAULT NULL,
  `idBaiDang` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idTP_idx` (`idThuePhong`),
  KEY `idBD_idx` (`idBaiDang`),
  CONSTRAINT `idBD` FOREIGN KEY (`idBaiDang`) REFERENCES `bai_dang` (`id`) ON DELETE CASCADE,
  CONSTRAINT `idTP` FOREIGN KEY (`idThuePhong`) REFERENCES `tai_khoan` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bai_da_luu`
--

LOCK TABLES `bai_da_luu` WRITE;
/*!40000 ALTER TABLE `bai_da_luu` DISABLE KEYS */;
INSERT INTO `bai_da_luu` VALUES (8,5,1),(9,5,3),(10,5,5),(11,6,1),(12,6,3),(13,6,5),(14,7,1),(15,7,6),(16,7,5);
/*!40000 ALTER TABLE `bai_da_luu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bai_dang`
--

DROP TABLE IF EXISTS `bai_dang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bai_dang` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idChuTro` int NOT NULL,
  `tenCT` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `khuVuc` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `soPhongTrong` int DEFAULT NULL,
  `gia` int DEFAULT NULL,
  `chiTiet` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `diemDanhGia` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idCT_idx` (`idChuTro`),
  CONSTRAINT `idCT` FOREIGN KEY (`idChuTro`) REFERENCES `tai_khoan` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bai_dang`
--

LOCK TABLES `bai_dang` WRITE;
/*!40000 ALTER TABLE `bai_dang` DISABLE KEYS */;
INSERT INTO `bai_dang` VALUES (1,2,'Huỳnh Minh Cường','Gia Lâm',3,2800000,'CHO THUÊ CĂN HỘ VINHOMES OCEAN PARK GIÁ TỐT\nĐầy đủ tiện nghi từ giường, đệm, tủ, máy giặt, điều hoà, tủ lạnh, nóng lạnh, nội thất xinh xắn đến cao cấp ạ\nGhép 1tr5/ng 2 người 1 phòng hoặc phòng riêng 2tr8-3tr bao phí, đầy đủ tiện nghi như trên , 1 căn riêng giá từ 3tr7\nĐiện nước giá theo giá nhà nước không thu hơn chi phí khác chỉ có vé xe nếu có 45k /tháng và mạng 50k nếu dùng\nĐược sủ dụng miễn phí tất cả tiện ích cho cư dân như bãi biển hồ bơi hay sân bóng rổ phòng gym vv...\nYêu cầu ko hút thuốc rượu bia. Lịch sự để môi trường sống mọi người trong phòng tốt nhất. (ai quá vô ý thức sẽ bị mời ṛa)\nĐể biết thêm thông tin chi tiết, liên hệ: 0333456412',8.666666666666666),(2,2,'Huỳnh Minh Cường','Hà Đông',2,2500000,'Đi bộ 10p tới trường. TẠI SAO KHÔNG???\nĐịa chỉ: Ngõ 1 số 10 đường 18M Mỗ Lao ( Cạnh chợ Mỗ Lao)\nCách HVCN Bưu Chính Viễn Thông 600m\nCách ĐH Kiến Trúc 800m\nCách HV An Ninh 1km\nSở hữu ngay căn phòng #Sang_Choảnh\nPhòng được thiết kế:\nSiêu thoáng: 2 mặt thoáng đón gió\nSiêu an toàn: ra vào có vân tay, camera 24/24\nNhà mới, 100% đồ mới đầy đủ tiện nghi như: gác xép giường, tủ, nóng lạnh, kệ bếp, kệ giày.\nWc riêng, không chung chủ, tự do về giờ giấc\nNhanh tay liên hệ chủ nhà : 0982955863 để chọn cho mình phòng ưng ý nhất nhé!',8.333333333333334),(3,3,'Phạm Văn Nghị','Hà Đông',3,3100000,'CCMN { CAO CẤP CHÍNH CHỦ } nhà mình còn phòng cho thuê\nĐC; Số nhà 43 xa la hà đông mặt phố.\nGần học viện quân y, viện 103, viển bỏng, viện k tần triều, cách 2km gần nhiều trường ĐH lớn.\nPhòng đẹp, thoáng, full đồ gồm > điều hoà -  nóng lạnh - tủ lạnh - máy giặt - máy sấy quần áo - máy hút mùi - bếp từ - tủ bếp trên dưới - ghế sofa và nhiều vật dụng hửu ích khác.\n- Mn nhanh tay lh 0862348389 để dk tư vấn nhiệt tình + thêm ưu đãi xincamon.',10),(4,4,'Nguyễn Hồng Hải','Thanh Xuân',8,2300000,'Cho thuê phòng trọ giá sinh viên.\nNgõ 133/32 xuân thủy.\nNgõ 211/77 khương trung.\nVệ sinh khesp kín\nĐiều hòa nóng lạnh\nGiường tủ .máy giặt\nĐể xe mien phi\nGio tu do k chung chu\nGia. 2.3 den 2.8\nSdt 0384767868 hoac 0878665678',6),(5,4,'Nguyễn Hồng Hải','Hà Đông',1,1700000,'Cho thuê phòng CCMN tại ngõ 68 Triều Khúc\nPhọng khép kín : điều hòa, nóng lạnh, bàn bếp, giường tủ, có ban công cửa sổ thoáng mát\nThanh toán 1 cọc 1 tháng\nToà nhà có bảo vệ 24/24 , nhân viên vệ sinh sửa chữa phục vụ chuyên nghiệp',7.666666666666667),(6,3,'Phạm Văn Nghị','Ba Đình',4,2000000,'Cho thuê phòng ở Đội Cấn\n- Nhà riêng 3 tầng 1 tum\n- Phòng riêng một mình ở tầng 3 rộng rãi thoải mái\n- Điện + Nước giá dân\n- Phơi quần áo ở tầng tum\n- WC rộng rãi, cạnh phòng ngủ\n- Phòng rồn thừa sức cho 4 người ở\n- Để xe trong nhà ở tầng 1\n- Bếp dưới tầng 1 sạch đẹp\n- Giá 2xxx/tháng có fix\n- Giờ giấc thoải mái sống độc lập\n- Nhà cách mặt đường 10m\n- LH: 0983853553',9);
/*!40000 ALTER TABLE `bai_dang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bao_cao`
--

DROP TABLE IF EXISTS `bao_cao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bao_cao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idGuiBC` int DEFAULT NULL,
  `idBiBC` int DEFAULT NULL,
  `loaiBC` int DEFAULT NULL,
  `noiDungBC` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `idBinhLuan` int DEFAULT NULL,
  `idBaiDang` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idGuiBC_idx` (`idGuiBC`),
  KEY `idBiBC_idx` (`idBiBC`),
  KEY `idBinhLuan_idx` (`idBinhLuan`),
  KEY `idBaiDang_idx` (`idBaiDang`),
  CONSTRAINT `idBaiDangg` FOREIGN KEY (`idBaiDang`) REFERENCES `bai_dang` (`id`) ON DELETE CASCADE,
  CONSTRAINT `idBiBC` FOREIGN KEY (`idBiBC`) REFERENCES `tai_khoan` (`id`) ON DELETE CASCADE,
  CONSTRAINT `idBinhluan` FOREIGN KEY (`idBinhLuan`) REFERENCES `binh_luan` (`id`) ON DELETE CASCADE,
  CONSTRAINT `idGuiBC` FOREIGN KEY (`idGuiBC`) REFERENCES `tai_khoan` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bao_cao`
--

LOCK TABLES `bao_cao` WRITE;
/*!40000 ALTER TABLE `bao_cao` DISABLE KEYS */;
INSERT INTO `bao_cao` VALUES (2,5,3,1,'giá phòng không đúng với thực tế khi tới xem',NULL,6),(3,6,4,1,'chủ trọ lừa đảo ',NULL,4),(4,7,4,1,'phòng bé so với mô tả',NULL,4),(7,4,5,2,'bình luận không chính xác',5,5),(8,3,5,2,'bình luận này có ý công kích tôi, nội dung không chính xác, mong admin xem xét',6,6);
/*!40000 ALTER TABLE `bao_cao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `binh_luan`
--

DROP TABLE IF EXISTS `binh_luan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `binh_luan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idBaiDang` int DEFAULT NULL,
  `idThuePhong` int DEFAULT NULL,
  `noiDung` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `unameTP` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idBaiDang_idx` (`idBaiDang`),
  KEY `idThuePhong_idx` (`idThuePhong`),
  CONSTRAINT `idBaiDang` FOREIGN KEY (`idBaiDang`) REFERENCES `bai_dang` (`id`) ON DELETE CASCADE,
  CONSTRAINT `idThuePhong` FOREIGN KEY (`idThuePhong`) REFERENCES `tai_khoan` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `binh_luan`
--

LOCK TABLES `binh_luan` WRITE;
/*!40000 ALTER TABLE `binh_luan` DISABLE KEYS */;
INSERT INTO `binh_luan` VALUES (1,1,5,'không gian yên tĩnh','toan'),(2,2,5,'xung quanh nhiều trộm cắp','toan'),(3,3,5,'không gian ok','toan'),(4,4,5,'hàng xóm thân thiện','toan'),(5,5,5,'hơi nhỏ','toan'),(6,6,5,'không gian ồn ào','toan'),(7,1,6,'phòng ok','van'),(8,2,6,'tạm được','van'),(9,3,6,'hàng xóm thân thiện','van'),(10,5,6,'hợp với sinh viên','van'),(11,6,6,'phòng bên ồn ào','van'),(12,1,7,'chủ nhà thân thiện','quang'),(13,2,7,'chủ nhà thân thiện','quang'),(15,4,7,'ổn','quang'),(16,6,7,'chủ nhà thân thiện','quang'),(17,5,7,'chủ nhà thân thiện','quang');
/*!40000 ALTER TABLE `binh_luan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `danh_gia`
--

DROP TABLE IF EXISTS `danh_gia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `danh_gia` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idBaiDang` int DEFAULT NULL,
  `idThuePhong` int DEFAULT NULL,
  `soDiem` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idBD_idx` (`idBaiDang`),
  KEY `idTP_idx` (`idThuePhong`),
  CONSTRAINT `idBai` FOREIGN KEY (`idBaiDang`) REFERENCES `bai_dang` (`id`) ON DELETE CASCADE,
  CONSTRAINT `idTPhong` FOREIGN KEY (`idThuePhong`) REFERENCES `tai_khoan` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danh_gia`
--

LOCK TABLES `danh_gia` WRITE;
/*!40000 ALTER TABLE `danh_gia` DISABLE KEYS */;
INSERT INTO `danh_gia` VALUES (1,1,5,9),(2,2,5,7),(3,3,5,10),(4,4,5,9),(5,5,5,8),(6,1,6,10),(7,2,6,8),(8,4,6,2),(9,5,6,8),(10,6,6,8),(11,1,7,7),(12,2,7,10),(13,4,7,7),(14,6,7,10),(15,5,7,7);
/*!40000 ALTER TABLE `danh_gia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tai_khoan`
--

DROP TABLE IF EXISTS `tai_khoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tai_khoan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `sdt` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `hoTen` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `diaChi` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `role` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tai_khoan`
--

LOCK TABLES `tai_khoan` WRITE;
/*!40000 ALTER TABLE `tai_khoan` DISABLE KEYS */;
INSERT INTO `tai_khoan` VALUES (1,'admin','admin','dungdd.ptit@gmail.com','0916862162','Dương Đình Dũng','Hà Tĩnh',3),(2,'cuong','123','minhcuong51020@gmail.com','0354876157','Huỳnh Minh Cường','Hà Nội',1),(3,'nghi','123','nghi@gmail.com','0456784592','Phạm Văn Nghị',NULL,1),(4,'hai','123','hai@gmail.com','0434875139','Nguyễn Hồng Hải',NULL,1),(5,'toan','123','toan@gmail.com','0123456487','Nguyễn Đức Toàn',NULL,2),(6,'van','123','van@gmail.com','09153475168','Phùng Hồng Vân',NULL,2),(7,'quang','123','quang@gmail.com','09131548716','Nguyễn Văn Đức Quang',NULL,2);
/*!40000 ALTER TABLE `tai_khoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thong_bao`
--

DROP TABLE IF EXISTS `thong_bao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thong_bao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idUser` int DEFAULT NULL,
  `noiDung` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `thoiGian` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idUser_idx` (`idUser`),
  CONSTRAINT `idUser` FOREIGN KEY (`idUser`) REFERENCES `tai_khoan` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thong_bao`
--

LOCK TABLES `thong_bao` WRITE;
/*!40000 ALTER TABLE `thong_bao` DISABLE KEYS */;
INSERT INTO `thong_bao` VALUES (1,4,'bạn cần cập nhật địa chỉ','2021-06-29'),(2,5,'Báo cáo bài đăng của bạn bị từ chối','2021-06-29'),(3,2,'Báo cáo bình luận của bạn bị từ chối','2021-06-29'),(4,2,'Báo cáo bình luận của bạn đã được xem xét và đồng ý xử lý vi phạm','2021-06-29');
/*!40000 ALTER TABLE `thong_bao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-30  2:07:33
