/* @provengo summon selenium */

/**
 * This story opens a new Prestashop window, goes to a product, and leaves a review as guest.
 */
story('Guest leaves a review for a product', function () {
  with (new SeleniumSession().start('http://localhost:8080/')) {
    goToProduct();
    fillReview({ title: 'Great Shirt', name: 'David', review: 'Really liked the fabric'});
    submitReview();
    OkPopup();
  }
})

/**
 * This story opens a new Prestashop window, goes to commenting module, and turns guest commenting off.
 */
story('Admin prevents guest commenting', function () {
  with (new SeleniumSession().start('http://localhost:8080/admin-demo-appendix')) {
    adminLogin({username: 'gadmicha@post.bgu.ac.il', password: 'sqproject3'});
    navigateToModule({module: 'comment'});
    turnOffCommenting();
  }
})

/////**
//// * This story verifies that a guest review was added.
//// */
//story('Check add comment before change', function () {
//  with (new SeleniumSession().start('http://localhost:8080')) {
//    goToProduct();
//    fillReview({ title: 'Great Shirt', name: 'David', review: 'Really liked the fabric'});
//    submitReview();
//    OkPopup();
//  }
//})
//
/////**
//// * This story verifies that if a guest is adding a review after the option to leave a review was turned
////   off by the admin, then the review won't be published.
//// */
//story('Check add comment after change', function () {
//  with (new SeleniumSession().start('http://localhost:8080')) {
//    adminLogin({username: 'gadmicha@post.bgu.ac.il', password: 'sqproject3'});
//    navigateToModule({module: 'comment'});
//    turnOffCommenting();
//  }
//})
//
/////**
//// * This story verifies that if a guest is adding a review while the option to leave a review was turned
////   off by the admin, then the review won't be published.
//// */
//story('Check add comment while change', function () {
//  with (new SeleniumSession().start('http://localhost:8080')) {
//    adminLogin({username: 'gadmicha@post.bgu.ac.il', password: 'sqproject3'});
//    navigateToModule({module: 'comment'});
//    turnOffCommenting();
//  }
//})