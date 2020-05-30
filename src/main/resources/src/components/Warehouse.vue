<template lang="pug">
.warehouse
  .title Склад
  .products
    .products__empty(v-if="products.length === 0") На складе нет товаров
    .product(v-for="product in products")
      .product__name {{ product.name }} ({{ product.manufacturer }})
      .product__price {{ product.price }}р.
</template>

<script>
export default {
  name: 'Warehouse',
  computed: {
    products() {
      return this.$store.getters.products
    }
  },
  created() {
    this.$store.dispatch('GET_PRODUCTS')
  },
  mounted() {
    const productsBlock = document.querySelector('.products')
    productsBlock.style.maxHeight = productsBlock.clientHeight - 3 + 'px'
  }
}
</script>

<style scoped lang="stylus">
@import './../styles/vars'

.title
  margin-bottom 15px

.products
  flex-grow 1
  width 90%
  padding 0 10px
  background-color #fff
  box-shadow 0 0 10px 0 rgba(#000, 0.25)
  border-radius 10px
  overflow-y auto
  &__empty
    font-size 22px
    text-align center
    margin-top 20px

.product
  display flex
  justify-content space-between
  align-items center
  padding 10px 0
  border-bottom 1px solid rgba($cBgDark, 0.5)
  &:last-child
    border-bottom none
</style>